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
@Controller
@SessionAttributes(value = "userInSession")
public class ModifProfilController {

    @Autowired
    private GestionUtilisateur gestionUtilisateur;

    private static Logger logger = Logger.getLogger("ConnexionController");

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
        logger.warning("modification du Profil utilisateur");
        return "modifProfil";
    }

    /**
     * Validation de la modification et retour à la page accueil
     * @param user
     * @return
     */
    @Autowired
    UtilisateurDAO utilDao;
    @RequestMapping(value="/valider-modification-profil", method= RequestMethod.POST)
    public String updateUtilisateur(@ModelAttribute("userInSession") Utilisateur user){
        logger.warning("Demande validation de la modification");
        if (user.getMotDePasse().isEmpty()) {
            Utilisateur util = gestionUtilisateur.trouverUtilisateurByLogin(user.getEmail());
            user.setMotDePasse(util.getMotDePasse());
        } else {
            user.setMotDePasse(PasswordEncrypt.encryptPassword(user.getMotDePasse()));
        }
        utilDao.save(user);
        return "profil";
    }
}
