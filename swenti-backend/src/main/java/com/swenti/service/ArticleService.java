package com.swenti.service;

import com.swenti.model.Article;
import com.swenti.repository.ArticleJpaRepository;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleJpaRepository articleJpaRepository;
    @Transactional(readOnly = true)
    public List<Article> LookupArticle(){
        return articleJpaRepository.findAll();
    }
}
