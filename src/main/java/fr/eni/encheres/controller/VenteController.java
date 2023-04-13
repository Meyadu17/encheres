package fr.eni.encheres.controller;

import fr.eni.encheres.bll.GestionArticle;
import fr.eni.encheres.bll.GestionRetrait;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.util.logging.Logger;

/**
 * Controller de la page d'accueil
 *
 * @author Jérémy G
 */

@Controller
@RequestMapping(value = "/validerConnexion")
@SessionAttributes(names = { "userInSession", "recherche" })
public class VenteController {

<<<<<<< Updated upstream
    @RequestMapping(value = "/vente", method = RequestMethod.GET)
    public String accueil(){
        return "vente";
=======
    @Autowired
    GestionArticle gestionArticle;
    @Autowired
    GestionRetrait gestionRetrait;
    @Autowired
    ServletContext context;

    private static Logger logger = Logger.getLogger("ConnexionController");

    @ModelAttribute("userInSession")
    public Utilisateur addMyBean1ToSessionScope() {
        logger.warning("Injection de l'attribut en session");
        return new Utilisateur();
    }

  /*@RequestMapping(value = "/creationNouvelleVente", method = RequestMethod.GET)
    public ModelAndView creerNouvelleVente(@ModelAttribute("userInSession") Utilisateur user)  {
        Article a = new Article();
        Retrait r = new Retrait(user.getRue(),user.getCodePostal(),user.getVille());
        a.setRetrait(r);
        a.setUtilisateur(user);
        ModelAndView mav = new ModelAndView("nouvelleVente","articleVendu",a);
        return mav;
    }*/

    @RequestMapping(value = "/creation-vente", method = RequestMethod.GET)
    public String creerNouvelleVente(){
        logger.warning("création nouvelle vente");
        return "nouvelleVente";
>>>>>>> Stashed changes
    }

    @RequestMapping(value = "/valider-nouvelleVente", method = RequestMethod.POST)
    public String validerNouvelleVente(@ModelAttribute("userInSession") Utilisateur user, @ModelAttribute("articleVendu") Article a) {
        Article article = new Article();
        Retrait r = new Retrait(user.getRue(),user.getCodePostal(),user.getVille());
        article.setRetrait(r);
        article.setUtilisateur(user);
        logger.warning("Demande validation");
        gestionRetrait.creerRetrait(a.getRetrait());
        gestionArticle.creerArticle(a);
        return "accueil";
    }



}

