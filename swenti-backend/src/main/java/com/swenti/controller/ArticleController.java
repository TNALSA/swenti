package com.swenti.controller;

import java.util.List;

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
    // 기사 목록 출력
//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping("/lookup/v1")
//    public ArticleResponseDto lookUpArticlesV1(){
//        List<Article> articles = articleService.LookupArticleV1();
//        for(Article a: articles){
//            System.out.println(a.getTitle());
//        }
//        return new ArticleResponseDto(articles);
//    }
    //@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/lookup/v1", produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public List<Article> lookUpArticlesV1(){
        List<Article> articles = articleService.LookupArticleV1();
        for(Article a: articles){
            System.out.println(a.getTitle());
        }
        return articles;
    }


    @GetMapping("/lookup/v2")
    public String lookUpArticlesV2(Model model){
        List<Article> articles = articleService.LookupArticleV2();
        for(Article a: articles){
            System.out.println(a.getTitle());
        }
        model.addAttribute("articles",articles);
        return "index.html";
    }

    // 기사 상세보기
    @GetMapping("/lookup/details/{articleId}")
    public ArticleResponseDto lookUpDetails(@PathVariable int articleId, Model model){
        System.out.println("기사 ID: "+articleId);
        Article article = articleService.LookupDetails(articleId);
        return new ArticleResponseDto(article);
    }
}
