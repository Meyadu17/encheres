package fr.eni.encheres.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.time.LocalDateTime;

/**
 * Entité representant une enchère
 *
 * @author  Jérémy
 */
@Getter
@Setter
@AllArgsConstructor
public class Encheres {

    @Column(name="date_enchere",nullable = false)
    private LocalDateTime dateEnchere;

    @Column(name="montant_enchere",nullable = false)
    private int montantEnchere;

    @Id
    @ManyToOne
    @JoinColumn(name="no_utilisateur", nullable= false)
    private Utilisateurs utilisateur;

    @Id
    @ManyToOne
    @JoinColumn(name="no_article", nullable = false)
    private Articles article;

}

