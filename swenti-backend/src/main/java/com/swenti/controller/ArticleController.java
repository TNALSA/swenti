package com.swenti.controller;

import java.util.List;

import com.swenti.controller.dto.article.ArticleListResponseDto;
import com.swenti.controller.dto.article.ArticleResponseDto;
import com.swenti.model.Article;
import com.swenti.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping(value = "/lookup/v1", produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public List<Article> lookUpArticlesV1(){
        List<Article> articles = articleService.LookupArticleV1();
        for(Article a: articles){
            System.out.println(a.getTitle());
        }
        return articles;
    }

    @GetMapping(value = "/lookup/v2", produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public ArticleListResponseDto lookUpArticlesV2(){
        List<Article> articles = articleService.LookupArticleV2();
        for(Article a: articles){
            System.out.println(a.getTitle());
            System.out.println(a.getWrited_date());
        }
        return new ArticleListResponseDto(articles);
    }

    // 기사 상세보기
    @GetMapping("/lookup/details/{articleId}")
    public ArticleResponseDto lookUpDetails(@PathVariable int articleId, Model model){
        System.out.println("기사 ID: "+articleId);
        Article article = articleService.LookupDetails(articleId);
        return new ArticleResponseDto(article);
    }
}
