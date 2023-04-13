package fr.eni.encheres.controller;

import fr.eni.encheres.bll.GestionUtilisateur;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;
import fr.eni.encheres.utils.PasswordEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

/**
 * Controller de la page inscription
 *
 * @author Sophie L
 */
@Controller
@SessionAttributes(names = { "userInSession"})
public class InscriptionController {

    //#region variable
    @Autowired
    UtilisateurDAO utilisateurDAO;

    @Autowired
    private GestionUtilisateur gestionUtilisateur;
    //#endregion variable

    private static Logger logger = Logger.getLogger("ConnexionController");
    @ModelAttribute("userInSession")
    public Utilisateur addMyBean1ToSessionScope() {
        logger.warning("Injection de l'attribut en session");
        return new Utilisateur();
    }

    @RequestMapping(value = "/creation_profil", method = RequestMethod.GET)
    public String creerUtilisateur() {
        logger.warning("Demande inscription");
        return "inscription";
    }

    //chargement d'utilisateur en session après remplissage des champs et click sur bouton validation
    @RequestMapping(value = "/validerInscription", method = RequestMethod.POST)
    public String validerinscrire(@ModelAttribute("userInSession") Utilisateur user, Model model) {
        logger.warning("Demande validation");
        //Contrôle de l'égalité des champs mot de passe et confirmation mot de passe
        if (!user.getMotDePasse().equals(user.getConfirmationMotDePasse())) {
            model.addAttribute("errorMessage","Les mots de passe ne correspondent pas.");
            return "inscription";
        } else {
            user.setMotDePasse(PasswordEncrypt.encryptPassword(user.getMotDePasse()));
            gestionUtilisateur.creerUtilisateur(user);
            return "accueilDeco";
        }
    }
}