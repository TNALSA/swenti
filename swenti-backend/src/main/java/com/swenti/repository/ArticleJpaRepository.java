package com.swenti.repository;

import com.swenti.model.Article;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//@Repository
public interface ArticleJpaRepository extends JpaRepository<Article, Integer> {
    @Query(value = "SELECT a.id, a.title, a.link, JSON_UNQUOTE(JSON_EXTRACT(a.images, '$.\"image 1\"')) as images, a.media FROM Article a", nativeQuery = true)
    List<Article> LookupArticle();

    @Query("SELECT a FROM Article a WHERE a.id = :id")
    Article LookupDetails(int id);
}
