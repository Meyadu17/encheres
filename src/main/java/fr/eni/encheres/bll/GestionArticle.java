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

}
