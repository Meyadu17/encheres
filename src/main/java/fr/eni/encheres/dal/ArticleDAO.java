package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDAO extends JpaRepository<Article, Integer> {


}
