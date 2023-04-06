package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service gerant un utilisateur
 * @author mdelage2021
 */
@Service
public class GestionUtilisateur {

    @Autowired
    UtilisateurDAO utilisateurDAO;

    public void creerUtilisateur(Utilisateur utilisateur) {

        Utilisateur userToFind = utilisateurDAO.findByPseudo(utilisateur.getPseudo());

        if (userToFind == null) {
            Utilisateur userToFindByPseudo = utilisateurDAO.findByPseudo(utilisateur.getPseudo());
            Utilisateur userToFindByEmail = utilisateurDAO.findByPseudo(utilisateur.getEmail());

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

}