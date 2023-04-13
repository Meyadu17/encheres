package fr.eni.encheres.bo;

import org.springframework.stereotype.Component;

@Component
public class Filter {
    private String filterArticle;

    private  Categorie categorie;

    public Filter() {
    }

    public Filter(String filterArticle) {
        this.filterArticle = filterArticle;
    }

    public String getFilterArticle() {
        return filterArticle;
    }

    public void setFilterArticle(String caractere) {
        this.filterArticle = caractere;
    }
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
