package fr.eni.encheres.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.time.LocalDateTime;

/**
 * Entité représentant un article
 *
 * @author mdelage2021
 */

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "article")
public class Article{

    public enum Etat{CREEE, ENCOURS, TERMINEE};

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
    @JoinColumn(name = "no_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "no_categorie", nullable = false)
    private Categorie categorie;

    @Column(name = "etat_enchere")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.CREEE;

    public Article() {

    }

    @Override
    public String toString() {
        return "Article{" +
                "articleID=" + article +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", debutEnchere=" + debutEnchere +
                ", finEnchere=" + finEnchere +
                ", prixInitial=" + prixInitial +
                ", prixVente=" + prixVente +
                ", utilisateur=" + utilisateur +
                ", categorie=" + categorie +
                ", etat=" + etat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return articleID == article.articleID && prixInitial == article.prixInitial && prixVente == article.prixVente && Objects.equals(nom, article.nom) && Objects.equals(description, article.description) && Objects.equals(debutEnchere, article.debutEnchere) && Objects.equals(finEnchere, article.finEnchere) && Objects.equals(utilisateur, article.utilisateur) && Objects.equals(categorie, article.categorie) && etat == article.etat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleID, nom, description, debutEnchere, finEnchere, prixInitial, prixVente, utilisateur, categorie, etat);
    }
}
