package fr.eni.encheres.controller;

import fr.eni.encheres.bll.GestionArticle;
import fr.eni.encheres.bo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("recherche")
public class ArticleController {

    @Autowired
    GestionArticle beanGA;

    @RequestMapping(value = "/rechercher", method = RequestMethod.POST)
    public ModelAndView rechercherArticle(@ModelAttribute("recherche")   Recherche stringToFind) {

        List<Article> articles = beanGA.listeArticlesEnCoursParNom(stringToFind.getCaractere());
        ModelAndView mav = new ModelAndView("rechercher", "articlesParNom", articles);
        return mav;
    }
}
