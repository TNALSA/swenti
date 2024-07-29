package com.swenti.repository;

import com.swenti.model.Article;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//@Repository
public interface ArticleJpaRepository extends JpaRepository<Article, Integer> {
    @Query("select a from Article a where date_format(a.writed_date,'%Y-%m-%d') = date_format(now(),'%Y-%m-%d')")
    List<Article> LookupArticle();

    @Query("select a from Article a where date_format(a.writed_date,'%Y-%m-%d') = date_format(now(),'%Y-%m-%d') and a.site = :site order by a.writed_date desc")
    List<Article> LookupBySite(String site);

    @Query("SELECT a FROM Article a WHERE a.id = :articleId")
    Article LookupDetails(@Param("articleId") int articleId);

    @Modifying
    @Query("UPDATE Article a SET a.view = a.view+1 WHERE a.id = :articleId")
    void LookupCount(@Param("articleId") int articleId);
}
