package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.dal.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
}
