package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateurs;
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

    public void creerUtilisateur(Utilisateurs utilisateur) {

        Utilisateurs userToFind = utilisateurDAO.findByPseudo(utilisateur.getPseudo());

        if (userToFind == null) {
            Utilisateurs userToFindByPseudo = utilisateurDAO.findByPseudo(utilisateur.getPseudo());
            Utilisateurs userToFindByEmail = utilisateurDAO.findByPseudo(utilisateur.getEmail());

            if (userToFindByPseudo == null && userToFindByEmail == null) {
                utilisateurDAO.save(utilisateur);
            } else if (userToFindByPseudo != null) {
                System.err.println(utilisateur.getPseudo() + " : ce pseudo est déjà utilisé.");
            } else if (userToFindByEmail != null) {
                System.err.println(utilisateur.getEmail() + " : cette adresse mail est déjà utilisée.");
            }
        }
    }

    public List<Utilisateurs> listeUtilisateurs() {
        List<Utilisateurs> utilisateurs = utilisateurDAO.findAll();
        return utilisateurs;
    }

}
