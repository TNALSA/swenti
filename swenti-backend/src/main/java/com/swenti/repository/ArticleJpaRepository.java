package com.swenti.repository;

import com.swenti.model.Article;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//@Repository
public interface ArticleJpaRepository extends JpaRepository<Article, Integer> {
    @Query("select a from Article a where date_format(a.writed_date,'%Y-%m-%d') = date_format(now(),'%Y-%m-%d')")
    List<Article> LookupArticle();

    @Query("SELECT a FROM Article a WHERE a.id = :id")
    Article LookupDetails(int id);
}
