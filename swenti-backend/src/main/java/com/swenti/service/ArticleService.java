package com.swenti.service;

import com.swenti.model.Article;
import com.swenti.repository.ArticleJpaRepository;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleJpaRepository articleJpaRepository;
    @Transactional(readOnly = true)
    public List<Article> LookupArticleV1(){
        return articleJpaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Article> LookupArticleV2(){
        return articleJpaRepository.LookupArticle();
    }

    @Transactional(readOnly = true)
    public List<Article> LookupArticleV3(String site){
        return articleJpaRepository.LookupBySite(site);
    }

    @Transactional(readOnly = true)
    public Article LookupDetails(int articleId){
        return articleJpaRepository.LookupDetails(articleId);
    }

    @Transactional
    public void LookupCount(int articleId) {
        articleJpaRepository.LookupCount(articleId);
    }
}
