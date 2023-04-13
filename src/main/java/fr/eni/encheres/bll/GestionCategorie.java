package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.CategorieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GestionCategorie {
    @Autowired
    CategorieDAO dao;

    public void creerCategorie(Categorie cat) {
        Categorie catCherchee = dao.findByLibelle(cat.getLibelle());
        if ( catCherchee == null) {
            dao.save(cat);
        } else {
            System.err.println("La categorie existe déjà");
        }
    }

    public List<Categorie> listeCategories() {
        List<Categorie> categories = dao.findAll();
        return categories;
    }

    public Categorie trouverCategorieByLibelle(String libelle) {
        Categorie cat = null;
        Categorie catCherchee = dao.findByLibelle(libelle);
        if ( catCherchee != null) {
            cat = catCherchee;
        } else {
            System.err.println("La categorie n'existe pas");
        }
        return cat;
    }
}
