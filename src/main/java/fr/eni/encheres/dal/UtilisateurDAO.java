package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDAO extends JpaRepository<Utilisateur, Integer> {

    Utilisateur findByPseudo(String pseudo);

    Utilisateur findByEmail(String login);
}
