package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Service gérant un utilisateur
 *
 * @author mdelage2021
 */
@Service
public class GestionUtilisateur {

    //#Region Variables
    private static Logger logger = Logger.getLogger("utilisateur");

    @Autowired
    UtilisateurDAO utilisateurDAO;
    //#Endregion Variables

    //creation nouveau compte
    public void creerUtilisateur(Utilisateur utilisateur) {

        Utilisateur userToFind = utilisateurDAO.findByPseudo(utilisateur.getPseudo());

        if (userToFind == null) {
            Utilisateur userToFindByPseudo = utilisateurDAO.findByPseudo(utilisateur.getPseudo());

            Utilisateur userToFindByEmail = utilisateurDAO.findByEmail(utilisateur.getEmail());

            if (userToFindByPseudo == null && userToFindByEmail == null) {
                utilisateur.setCompteActif(true);
                utilisateur.setCredit(100);
                utilisateurDAO.save(utilisateur);
            } else if (userToFindByPseudo != null) {
                System.err.println(utilisateur.getPseudo() + " : ce pseudo est déjà utilisé.");
            } else if (userToFindByEmail != null) {
                System.err.println(utilisateur.getEmail() + " : cette adresse mail est déjà utilisée.");
            }
        }
    }

    public List<Utilisateur> listeUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurDAO.findAll();
        return utilisateurs;
    }

    public Utilisateur trouverUtilisateur(Utilisateur utilisateur) {
        Optional<Utilisateur> userFound = utilisateurDAO.findById(utilisateur.getNoUtilisateur());
        if (userFound.isEmpty()) {
            utilisateur = null;
        } else {
            utilisateur = userFound.get();
        }
        return utilisateur;
    }

    public Utilisateur trouverUtilisateurByLogin(String login) {
        Utilisateur utilisateur = null;
        Utilisateur uPseudo = utilisateurDAO.findByPseudo(login);
        Utilisateur uMail = utilisateurDAO.findByEmail(login);
        if (uPseudo != null) {
            utilisateur = uPseudo;
        } else if (uMail != null) {
            utilisateur = uMail;
        }
        return utilisateur;
    }

    public Utilisateur trouverUtilisateurByLoginPwd(String login, String passWord) {
        Utilisateur utilisateur = null;
        Utilisateur utilisateurPseudo = utilisateurDAO.findByPseudo(login);
        Utilisateur uMail = utilisateurDAO.findByEmail(login);
        if (utilisateurPseudo != null && utilisateurPseudo.getMotDePasse().equals(passWord)) {
            utilisateur = utilisateurPseudo;
        } else if (uMail != null && uMail.getMotDePasse().equals(passWord)) {
            utilisateur = uMail;
        }
        return utilisateur;
    }

    public void modifierUtilisateur(Utilisateur utilisateur) {
        Utilisateur utilisateurTrouve = trouverUtilisateur(utilisateur);
        if (utilisateurTrouve != null) {
            utilisateurDAO.save(utilisateur);
            System.err.println("utilisateur modifié");
        } else {
            System.err.println("L'utilisateur n'existe pas");
        }
    }

}
