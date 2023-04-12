package fr.eni.encheres.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Entité qui represent une Categorie
 *
 * @author mdelage2021
 */
@Getter
@Setter
@AllArgsConstructor
@Entity(name = "categorie")
public class Categorie {

    @Id
    @Column(name = "no_categorie", nullable = false)
    private int categorie;

    @Column(name = "libelle", length = 30, nullable = false)
    private String libelle;

    @OneToMany
    private List<Article> articles;
}
