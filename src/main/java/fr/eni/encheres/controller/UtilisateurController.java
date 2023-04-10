package fr.eni.encheres.controller;

import fr.eni.encheres.bll.GestionUtilisateur;
import fr.eni.encheres.bo.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.logging.Logger;

/**
 * Controller gerant un utilisateur
 *
 * @author melody
 */
@Controller
@SessionAttributes(names = { "userInSession" , "recherche"})
public class UtilisateurController {
    //#regrion variables
    private static Logger logger = Logger.getLogger("ConnexionController");
    private GestionUtilisateur beanGU;
    //#endergion variables

    @ModelAttribute("userInSession")
    public Utilisateur addMyBean1ToSessionScope() {
        logger.warning("Injection de l'attribut en session");
        return new Utilisateur();
    }

    @RequestMapping(value = "/profil", method = RequestMethod.GET)
    public String informationUtilisateur() {
        logger.warning("Profil utilisateur");
        return "profil";
    }
}
