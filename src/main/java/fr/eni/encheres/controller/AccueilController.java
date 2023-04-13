package fr.eni.encheres.controller;

import fr.eni.encheres.bll.GestionArticle;
import fr.eni.encheres.bll.GestionCategorie;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;

import fr.eni.encheres.bo.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Controller de la page d'accueil
 *
 * @author Jérémy G
 */
@Controller
@SessionAttributes({"filterArticle", "filterCategorie"})
public class AccueilController {

    //#region variables
    @Autowired
    GestionArticle beanGA;
    @Autowired
    GestionCategorie beanGC;
    @Autowired
    ServletContext context;

    private static Logger logger = Logger.getLogger("AccueilController");
    public static Map<String, Categorie> lesCategories = new HashMap<>();
    //#endregion variable

    @ModelAttribute("filterArticle")
    public Filter addMyBean1ToSessionScope1() {
        logger.warning("Injection de l'attribut en session");
        return new Filter();
    }

    @ModelAttribute("filterCategorie")
    public Filter addMyBean1ToSessionScope2() {
        logger.warning("Injection de l'attribut en session");
        return new Filter();
    }

    @PostConstruct
    public void categorieFilter() {
        logger.warning("Injection de la liste des categories dans l appli");
        List <Categorie> categories = beanGC.listeCategories();
        context.setAttribute("categories", categories);
        for (Categorie cat : categories) {
            lesCategories.put(cat.getLibelle(), cat);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView Accueil() {
        List<Article> articles = beanGA.listeArticlesEnCours();
        ModelAndView mav = new ModelAndView("accueil" , "articles" , articles);
        return mav;
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public ModelAndView viewHomePage(Model model, @ModelAttribute("filterArticle") Filter stringToFind) {

        model.addAttribute("filterArticle", stringToFind);
        // cas categorie renseignée différent de all

        List<Article> articles = beanGA.listAllByName(stringToFind.getFilterArticle());
        ModelAndView mav = new ModelAndView("accueil", "articles", articles);
        return mav;

    }

    @RequestMapping(value = "/filterCategorie", method = RequestMethod.GET)
    public ModelAndView viewHomePage2(Model model, @ModelAttribute("filterCategorie") Filter stringToFind) {

        model.addAttribute("filterArticle", stringToFind);
        List<Article> articles = beanGA.listeArticlesEnCoursParCategorie(stringToFind.getCategorie().getLibelle());
        ModelAndView mav = new ModelAndView("accueil", "articles", articles);
        return mav;
    }

}
