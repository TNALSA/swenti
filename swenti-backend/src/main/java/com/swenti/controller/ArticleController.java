package com.swenti.controller;

import java.util.List;
import com.swenti.controller.dto.article.ArticleListResponseDto;
import com.swenti.controller.dto.article.ArticleResponseDto;
import com.swenti.model.Article;
import com.swenti.model.Comment;
import com.swenti.service.ArticleService;
import com.swenti.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ArticleController {
    private final ArticleService articleService;
    private final CommentService commentService;

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

    @PostMapping("/lookup/v3/{site}")
    public ArticleListResponseDto lookUpArticlesV3(@PathVariable String site){
        System.out.println("요청 사이트:" + site);
        List<Article> articles = articleService.LookupArticleV3(site);
        return new ArticleListResponseDto(articles);
    }

    // 기사 상세보기
    @GetMapping("/lookup/details/{articleId}")
    public ArticleResponseDto lookUpDetails(@PathVariable int articleId){
        Article article = articleService.LookupDetails(articleId);
        List<Comment> comments = commentService.lookupComments(articleId);
        return new ArticleResponseDto(article, comments);
//        return new ArticleResponseDto(article);
    }
}
