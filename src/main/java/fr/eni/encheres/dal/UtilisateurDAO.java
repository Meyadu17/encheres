package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDAO extends JpaRepository<Utilisateurs, Integer> {

    Utilisateurs findByPseudo(String pseudo);

    Utilisateurs findByEmail(String login);
}
