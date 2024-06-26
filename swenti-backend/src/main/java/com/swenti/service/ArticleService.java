package com.swenti.service;

import com.swenti.model.Article;
import com.swenti.repository.ArticleJpaRepository;
import java.util.List;
import java.util.Optional;

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

    public List<Article> LookupArticleV2(){
        return articleJpaRepository.LookupArticle();
    }

    @Transactional(readOnly = true)
    public Optional<Article> LookupDetails(int id){
        return articleJpaRepository.findById(id);
    }

}
