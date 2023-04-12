package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository

public interface ArticleDAO extends JpaRepository<Article, Integer> {
<<<<<<< Updated upstream
    @Query(value ="SELECT * FROM article a WHERE a.nom_article LIKE %?%", nativeQuery = true)
   List<Article> search(String keyword);
=======

>>>>>>> Stashed changes
}
