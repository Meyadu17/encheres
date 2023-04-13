package fr.eni.encheres.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
<<<<<<< Updated upstream
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
=======
import javax.persistence.*;
import javax.validation.constraints.NotNull;
>>>>>>> Stashed changes
import java.time.LocalDateTime;

/**
 * Entité représentant un article
 *
 * @author mdelage2021
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
<<<<<<< Updated upstream
=======
@NoArgsConstructor
>>>>>>> Stashed changes
@Table(name = "article")
public class Article{

    public enum Etat {CREEE, ENCOURS, TERMINEE, RETIREE};

    @Id
    @Column(name = "no_article", nullable = false)
    private int article;

    @Column(name = "nom_article", length = 30, nullable = false)
    private  String nom;

    @Column(name = "description", length = 300, nullable = false)
    private  String description;

    @Column(name = "date_debut_encheres", nullable = false)
    private LocalDateTime debutEnchere;

    @Column(name = "date_fin_encheres", nullable = false)
    private LocalDateTime finEnchere;

    @Column(name = "prix_initial")
    private int prixInitial;

    @Column(name = "prix_vente")
    private int prixVente;

    @ManyToOne
    @JoinColumn(name = "no_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "no_categorie", nullable = false)
    private Categorie categorie;

    @Column(name = "etat_enchere")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.CREEE;

    @OneToOne
    private Retrait retrait;

}
