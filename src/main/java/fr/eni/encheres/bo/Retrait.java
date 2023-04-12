package fr.eni.encheres.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Entité représentant un retrait
 *
 * @author mdelage2021
 */
@Getter
@Setter
@AllArgsConstructor
@Entity(name = "retrait")
public class Retrait {

    @Id
    @Column(name = "no_article", nullable = false)
    private int article;

    @Column(name = "rue", length = 255, nullable = false)
    private  String rue;

    @Column(name = "code_postal", length = 5, nullable = false)
    private String codePostal;

    @Column(name = "ville", length = 255, nullable = false)
    private String ville;

}
