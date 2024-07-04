package com.swenti.repository;

import com.swenti.model.Article;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//@Repository
public interface ArticleJpaRepository extends JpaRepository<Article, Integer> {
<<<<<<< HEAD
    @Query("select a from Article a where date_format(a.writed_date,'%Y-%m-%d') = date_format(now(),'%Y-%m-%d')")
=======
    @Query(value = "SELECT a.id, a.title, a.link, JSON_UNQUOTE(JSON_EXTRACT(a.images, '$.\"image 1\"')) as images, a.media FROM Article a", nativeQuery = true)
>>>>>>> c11cc9b28ecb1523fba6bf14d0fb32b861dce1e6
    List<Article> LookupArticle();

    @Query("SELECT a FROM Article a WHERE a.id = :id")
    Article LookupDetails(int id);
}
