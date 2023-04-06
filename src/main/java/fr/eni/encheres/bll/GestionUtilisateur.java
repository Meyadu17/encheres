package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service gerant un utilisateur
 * @author mdelage2021
 */
@Service
public class GestionUtilisateur {

    @Autowired
    UtilisateurDAO utilisateurDAO;

//creation nouveau compte

    public void creerUtilisateur(Utilisateur utilisateur) {

        Utilisateur userToFind = utilisateurDAO.findByPseudo(utilisateur.getPseudo());

        if (userToFind == null) {
            Utilisateur userToFindByPseudo = utilisateurDAO.findByPseudo(utilisateur.getPseudo());

            Utilisateur userToFindByEmail = utilisateurDAO.findByEmail(utilisateur.getEmail());

            if (userToFindByPseudo == null && userToFindByEmail == null) {
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

    public Utilisateur trouverUtilisateurByLogin(Utilisateur utilisateur) {
        Optional<Utilisateur> userFound = utilisateurDAO.findById(utilisateur.getNoUtilisateur());
        if (userFound.isEmpty()) {
            utilisateur = null;
        } else {
            utilisateur = userFound.get();
        }
        return utilisateur;
    }
}
