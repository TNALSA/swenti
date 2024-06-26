package com.swenti.controller;

import java.util.List;
import com.swenti.model.Article;
import com.swenti.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class LookupArticleController {
    private final ArticleService articleService;
    @GetMapping("/lookup")
    public String lookUpArticle(Model model){
        List<Article> articles = articleService.LookupArticle();
        for(Article a: articles)
            System.out.println(a.getTitle());
        model.addAttribute("articles",articles);
        return "index.html";
    }
}
