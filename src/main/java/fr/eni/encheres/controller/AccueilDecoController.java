package fr.eni.encheres.controller;

import fr.eni.encheres.bll.GestionArticle;
import fr.eni.encheres.bll.GestionCategorie;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

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
@SessionAttributes("recherche")
public class AccueilDecoController {
    @Autowired
    GestionArticle beanGA;
    @Autowired
    GestionCategorie beanGC;
    @Autowired
    ServletContext context;


    private static Logger logger = Logger.getLogger("ConnexionController");
    public static Map<String, Categorie> lesCategories = new HashMap<>();

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
        ModelAndView mav = new ModelAndView("accueilDeco" , "articles" , articles);
        return mav;
    }

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Article> listProducts = beanGA.listAll(keyword);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("keyword", keyword);
        return "accueilDeco";
    }
}
