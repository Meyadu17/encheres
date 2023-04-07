package fr.eni.encheres.controller;

import fr.eni.encheres.bll.GestionUtilisateur;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
@SessionAttributes(names = { "userInSession"})
public class InscriptionController {

    @Autowired
    UtilisateurDAO utilisateurDAO;

    @ModelAttribute("userInSession")
    public Utilisateur addMyBean1ToSessionScope() {
        logger.warning("Injection de l'attribut en session");
        return new Utilisateur();
    }
    private static Logger logger = Logger.getLogger("ConnexionController");

    @Autowired
    private GestionUtilisateur beanGU;

    @RequestMapping(value = "/creation_profil", method = RequestMethod.GET)
    public String creerUtilisateur() {
        logger.warning("Demande inscription");
        return "inscription";
    }


    //chargement d'utilisateur en session apres remplissage des champs et click sur bouton validation
    @RequestMapping(value = "/validerInscription", method = RequestMethod.POST)
    public String validerinscrire(@ModelAttribute("userInSession") Utilisateur user) {
        logger.warning("Demande validation");
        beanGU.creerUtilisateur(user);
        return "accueil";
    }
}
