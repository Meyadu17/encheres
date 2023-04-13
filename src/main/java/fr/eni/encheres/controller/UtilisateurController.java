package fr.eni.encheres.controller;

import fr.eni.encheres.bll.GestionUtilisateur;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @Autowired
    UtilisateurDAO utilisateurDAO;

    //#regrion variables
    private static Logger logger = Logger.getLogger("ConnexionController");

    @Autowired
    private GestionUtilisateur gestionUtilisateur;
    //#endergion variables

    //Ouverture de la session
    @ModelAttribute("userInSession")
    public Utilisateur addMyBean1ToSessionScope() {
        logger.warning("Injection de l'attribut en session");
        return new Utilisateur();
    }
}
