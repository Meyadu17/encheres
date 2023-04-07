package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.enumenation.Etat;
import fr.eni.encheres.dal.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GestionArticle {

    @Autowired
    ArticleDAO articleDAO;

    public void creerArticle(Article a) {
        articleDAO.save(a);
    }

    public List<Article> listeArticles() {
        List<Article> articles = articleDAO.findAll();
        return articles;
    }

    public List<Article> listeArticlesEnCours() {
        List<Article> articles = articleDAO.findAll();
        List<Article> articlesEnCours = new ArrayList<>();
        for (Article a : articles) {
            if(a.getEtat().equals(Etat.ENCOURS)) {
                articlesEnCours.add(a);
            }
        }
        return articlesEnCours;
    }

    public List<Article> listeArticlesEnCoursParNom(String carac) {
        List<Article> articles = listeArticlesEnCours();
        List<Article> articlesParNom = new ArrayList<>();
        for (Article a : articles) {
            if(a.getNom().contains(carac)) {
                articlesParNom.add(a);
            }
        }
        return articlesParNom;
    }

    public List<Article> listeArticlesEnCoursParCategorie(String libelle) {
        List<Article> articles = listeArticlesEnCours();
        List<Article> articlesParCategorie = new ArrayList<>();
        for (Article a : articles) {
            if(a.getCategorie().getLibelle().equalsIgnoreCase(libelle)) {
                articlesParCategorie.add(a);
            }
        }
        return articlesParCategorie;
    }


    public Optional<Article> trouverArticleById (int id) {
        Optional<Article> article = articleDAO.findById(id);
		/*if (articleTrouve.isPresent()) {
			article = articleTrouve.get(); ---> pêrmet de recup l objet s'il n'est pas vide / a tester dans le controller
		}*/
        return article;
    }

    public void modifierArticle (Article art) throws Exception {
        Optional<Article> articleToFind = articleDAOfindById(art.getArticleID());
        if (articleToFind.isPresent()) {
            Article article = articleToFind.get();
            if (LocalDate.now().isBefore(article.getDateDebutEncheres())) {
                articleDAO.save(art);
            } else {
                throw new Exception("Trop tard pour modifier");
            }
        } else {
            throw new Exception("Article non present");
        }
        //TODO : gerer les exceptions de modifArticle ou condition dans Controller
    }

    public void miseAJourEtatPrixVente (Article art) throws Exception {
        Optional<Article> articleToFind = articleDAO.findById(art.getArticleID());
        if (articleToFind.isPresent()) {
            Article article = articleToFind.get();
            articleDAO.save(art);
        } else {
            throw new Exception("Article non present");
        }
        //TODO : gerer les exceptions de modifArticle ou condition dans Controller
    }

    public void supprimerArticle (Article art) throws Exception {
        Optional<Article> articleToFind = articleDAO.findById(art.getArticleID());
        if (articleToFind.isPresent()) {
            Article article = articleToFind.get();

            if (LocalDate.now().isBefore(article.getDateDebutEncheres())) {
                articleDAO.delete(art);
            } else {
                throw new Exception("Trop tard pour supprimer");
            }
        } else {
            throw new Exception("Article non present");
        }
        //TODO : gerer les exceptions de suppressionArticle
    }

    public void majEtatdeVente() throws Exception{
        // TODO : gerer l'etat de vente en batch ou procedure stockée ??

        List<Article> articles = articleDAO.findAll();
        LocalDate now = LocalDate.now();
        for (Article a : articles) {
            if (a.getDateFinEncheres().isEqual(now) || a.getDateFinEncheres().isBefore(now)) {
                a.setEtat(Etat.TERMINEE);
                miseAJourEtatPrixVente(a);
                System.err.println("passage en condition termine");
            } else if (a.getDateDebutEncheres().isEqual(now) || a.getDateDebutEncheres().isBefore(now)) {
                a.setEtat(Etat.ENCOURS);
                miseAJourEtatPrixVente(a);
                System.err.println("passage en condition en cours");
            } System.err.println("bordel");
        }
    }
}
