package fr.eni.encheres.controller;

import fr.eni.encheres.bll.GestionUtilisateur;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.utils.PasswordEncrypt;
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
    private GestionUtilisateur gestionUtilisateur;
    //#endergion variables


    //Ouverture de la session
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

    /**
     * Mapping de la page modifier le profil de l'utilisateur
     * @return modifProfil
     */
    @RequestMapping(value = "/modifier-profil", method = RequestMethod.GET)
    public String modificationUtilisateur() {
        logger.warning("Profil utilisateur");
        return "modifProfil";
    }

    /**
     * Validation de la modificatino et retou rà la page profil
     * @param user
     * @return
     */
    @RequestMapping(value = "/validerModification", method = RequestMethod.POST)
    public String validerModification(@ModelAttribute("userInSession") Utilisateur user) {
        logger.warning("Demande validation de la modification");
        user.setMotDePasse(PasswordEncrypt.encryptPassword(user.getMotDePasse()));
        gestionUtilisateur.creerUtilisateur(user);
        return "profil";
    }
}
