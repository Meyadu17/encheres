package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.dal.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
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

    public List<Article> listAll() {
        return articleDAO.findAll();
    }
    public List<Article> listAllByName(String nom) {
        if(nom != null){
            return articleDAO.search(nom);
        }
        return this.listAll();
    }

    public List<Article> listeArticlesEnCours() {
        List<Article> articles = articleDAO.findAll();
        List<Article> articlesEnCours = new ArrayList<>();
        for (Article a : articles) {
            if(a.getEtat().equals(Article.Etat.ENCOURS)) {
                articlesEnCours.add(a);
            }
        }
        return articlesEnCours;
    }

    public List<Article> listeArticlesEnCoursParNom(String caractere) {
        List<Article> articles = listeArticlesEnCours();
        List<Article> articlesParNom = new ArrayList<>();
        for (Article a : articles) {
            if(a.getNom().contains(caractere)) {
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
        return article;
    }

    public void modifierArticle (Article art) throws Exception {
        Optional<Article> articleToFind = articleDAO.findById(art.getArticleID());
        if (articleToFind.isPresent()) {
            Article article = articleToFind.get();
            if (LocalDate.now().isBefore(ChronoLocalDate.from(article.getDebutEnchere()))) {
                articleDAO.save(art);
            } else {
                throw new Exception("Vous ne pouvez plus modifier l'article");
            }
        } else {
            throw new Exception("Article non présent");
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

            if (LocalDate.now().isBefore(ChronoLocalDate.from(article.getDebutEnchere()))) {
                articleDAO.delete(art);
            } else {
                throw new Exception("Vous ne pouvez plus modifier l'article");
            }
        } else {
            throw new Exception("Article non présent");
        }
        //TODO : gerer les exceptions de suppressionArticle
    }

    public void majEtatdeVente() throws Exception{
        // TODO : gerer l'etat de vente en batch ou procedure stockée ??

        List<Article> articles = articleDAO.findAll();
        LocalDate now = LocalDate.now();
        for (Article a : articles) {
            if (a.getFinEnchere().isEqual(now.atStartOfDay()) || a.getFinEnchere().isBefore(now.atStartOfDay())) {
                a.setEtat(Article.Etat.TERMINEE);
                miseAJourEtatPrixVente(a);
                System.err.println("passage en condition vente terminée");
            } else if (a.getDebutEnchere().isEqual(now.atStartOfDay()) || a.getDebutEnchere().isBefore(now.atStartOfDay())) {
                a.setEtat(Article.Etat.ENCOURS);
                miseAJourEtatPrixVente(a);
                System.err.println("passage en condition EN COURS");
            } System.err.println("problème");
        }
    }
}
