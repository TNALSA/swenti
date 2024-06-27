package com.swenti.controller;

import java.util.List;
import java.util.Optional;

import com.swenti.model.Article;
import com.swenti.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class ArticleController {
    private final ArticleService articleService;
    // 기사 목록 출력
    @GetMapping("/lookup/v1")
    public String lookUpArticlesV1(Model model){
        List<Article> articles = articleService.LookupArticleV1();
        for(Article a: articles){
            System.out.println(a.getTitle());
        }

        model.addAttribute("articles",articles);
        return "index.html";
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
    @GetMapping("/lookup/details")
    public String lookUpDetails(int id, Model model){
        Optional<Article> article = articleService.LookupDetails(id);
        model.addAttribute("article", article);
        return "datailPage.html";
    }
}
