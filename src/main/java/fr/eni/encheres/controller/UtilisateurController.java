package fr.eni.encheres.controller;

import fr.eni.encheres.bll.GestionUtilisateur;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;
import fr.eni.encheres.utils.PasswordEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UtilisateurDAO utilisateurDAO;
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

    @RequestMapping(value = "/validerModification", method = RequestMethod.POST)
    public String updateUtilisateur(@ModelAttribute("userInSession") Utilisateur user){
        logger.warning("Demande validation de la modification");
        if (user.getMotDePasse().isEmpty()) {
            Utilisateur util = gestionUtilisateur.trouverUtilisateurByLogin(user.getEmail());
            user.setMotDePasse(util.getMotDePasse());
        } else {
            user.setMotDePasse(PasswordEncrypt.encryptPassword(user.getMotDePasse()));
        }
        utilisateurDAO.save(user);
        return "profil";
    }

    @RequestMapping(value = "/modifier-profil", method = RequestMethod.GET)
    public String modificationUtilisateur() {
        logger.warning("Profil utilisateur");
        return "modifProfil";
    }
}
