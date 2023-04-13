package fr.eni.encheres.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Entité representant une enchère
 *
 * @author  Jérémy
 */
@Getter
@Setter
@AllArgsConstructor
@Table(name="enchere")
public class Enchere {

    @Column(name="date_enchere",nullable = false)
    private LocalDateTime dateEnchere;

    @Column(name="montant_enchere",nullable = false)
    private int montantEnchere;

    @Id
    @ManyToOne
    @JoinColumn(name="no_utilisateur", nullable= false)
    private Utilisateur utilisateur;

    @Id
    @ManyToOne
    @JoinColumn(name="no_article", nullable = false)
    private Article article;
}

