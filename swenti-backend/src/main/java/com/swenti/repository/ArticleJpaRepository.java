package com.swenti.repository;

import com.swenti.model.Article;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//@Repository
public interface ArticleJpaRepository extends JpaRepository<Article, Integer> {
    @Query(value = "SELECT id, title, link, JSON_UNQUOTE(JSON_EXTRACT(images, '$.\"image 1\"')) as images, media FROM article", nativeQuery = true)
    List<Article> LookupArticle();
}
