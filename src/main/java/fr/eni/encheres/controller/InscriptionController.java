package fr.eni.encheres.controller;

import fr.eni.encheres.bll.GestionUtilisateur;
import fr.eni.encheres.bo.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.util.logging.Logger;

@Controller
@SessionAttributes(names = { "userInSession" , "recherche"})
public class InscriptionController {

    @ModelAttribute("userInSession")
    public Utilisateur addMyBean1ToSessionScope() {
        logger.warning("Injection de l'attribut en session");
        return new Utilisateur();
    }
    private static Logger logger = Logger.getLogger("ConnexionController");

   // @Autowired
    //private GestionUtilisateur beanGU;

    @RequestMapping(value = "/creation_profil", method = RequestMethod.GET)
    public String creerUtilisateur() {
        logger.warning("Demande inscription");
        return "inscription";
    }

    @RequestMapping(value = "/validerInscription", method = RequestMethod.POST)
    public String validerInscription(@ModelAttribute("userInSession") Utilisateur user) {
        logger.warning("Valider inscription");
        return "accueil";

    }

}