package fr.eni.encheres.controller;


import fr.eni.encheres.bo.Article;
import fr.eni.encheres.dal.ArticleDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;


/**
 * Controller de la page d'accueil
 *
 * @author Jérémy G
 */
@Controller
public class VenteController {

    @Autowired
    ArticleDAO articleDAO;
    private static Logger logger = Logger.getLogger("venteController");
    @ModelAttribute("articleInSession")
    public Article addMyBean1ToSessionScope() {

        logger.warning("Injection de l'article en session");
        return new Article();
    }

    @RequestMapping(value = "/vente", method = RequestMethod.GET)
    public String accueil(){

        return "vente";
    }

    @RequestMapping(value = "/vente", method = RequestMethod.POST)
    public String creerVente(Model model, @ModelAttribute("articleInSession") Article article){
        model.addAttribute("articleInSession", article);
        articleDAO.save(article);
        return "accueil";
    }
}
