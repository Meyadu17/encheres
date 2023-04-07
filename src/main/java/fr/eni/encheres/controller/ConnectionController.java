package fr.eni.encheres.controller;

import fr.eni.encheres.bll.GestionUtilisateur;
import fr.eni.encheres.bo.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * Controller de la page de connexion
 *
 * @author mdelage2021
 */
@Controller
@SessionAttributes(names = { "userInSession" , "recherche"})
public class ConnectionController {
    private static Logger logger = Logger.getLogger("ConnexionController");

    @Autowired
    private GestionUtilisateur gestionUtilisateur;

    @Autowired
    private SessionLocaleResolver localeResolver;

    @ModelAttribute("userInSession")
    public Utilisateur addMyBean1ToSessionScope() {
        logger.warning("Injection de l'attribut en session");
        return new Utilisateur();
    }

    @RequestMapping(value = "/validerConnexion", method = RequestMethod.POST)
    public String verfiConnectionUtilisateur(Model mm, @ModelAttribute("userInSession") Utilisateur user) {
        logger.warning("Voici les données saisies par le client : " + user);
        Utilisateur utilisateurEnBase = gestionUtilisateur.trouverUtilisateurByLogin(user.getEmail());
        if (utilisateurEnBase == null) {
            return "login";
        } else {
            user.setNom(utilisateurEnBase.getNom());
            mm.addAttribute("userInSession", utilisateurEnBase);
            return "welcome";
        }
    }

    @RequestMapping(value = "/connexion", method = RequestMethod.POST)
    public String verifConnectionUtilisateur(Model model, @ModelAttribute("userInSession") Utilisateur user) {
        logger.warning("Voici les données saisies par le client : " + user);
        Utilisateur utilisateurEnBase = gestionUtilisateur.trouverUtilisateurByLogin(user.getEmail());
        if (utilisateurEnBase == null) {
            return "login";
        } else {
            user.setNom(utilisateurEnBase.getNom());
            model.addAttribute("userInSession", utilisateurEnBase);
            return "welcome";
        }
    }

    @RequestMapping(value = "/deconnexion", method = RequestMethod.GET)
    public String deconnecterUtilisateur(SessionStatus status) {
        status.setComplete();
        return "login";
    }

    @RequestMapping(value = "/connexion", method = RequestMethod.GET)
    public String demandeConnexionUtilisateur() {
        logger.warning("Demande de connexion");
        return "login";

    }


    @RequestMapping(value = "/i18n", method = RequestMethod.GET)
    public String choixDelaLangue(String lg) {
        Locale locale = new Locale(lg);
        localeResolver.setDefaultLocale(locale);
        return "login";
    }
}
