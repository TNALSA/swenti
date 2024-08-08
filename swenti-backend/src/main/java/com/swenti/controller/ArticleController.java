package com.swenti.controller;

import java.util.List;

import com.swenti.controller.dto.article.response.GetArticleListDto;
import com.swenti.controller.dto.article.response.GetArticleDto;
import com.swenti.model.Article;
import com.swenti.model.Comment;
import com.swenti.service.ArticleService;
import com.swenti.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;
    private final CommentService commentService;

    /**
     * 메소드 명: lookUpArticlesV1()
     * 기능: 뉴스 기사 리스트 불러오기
     * 별도의 dto 클래스를 사용하지 않고 articles 객체를 그대로 반환
     * @return article
     */
    @GetMapping(value = "/lookup/v1", produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public List<Article> lookUpArticlesV1(){
        List<Article> articles = articleService.LookupArticleV1();
        for(Article a: articles){
            System.out.println(a.getTitle());
        }
        return articles;
    }

    /**
     * 메소드 명: lookUpArticlesV2()
     * 기능: lookUpArticlesV1()과 동일 하나, 기사 작성 일자가 now() 일자와 같은 기사 리스트만 불러옴
     * ArticleListResponseDto의 객체 형태로 반환 -> 반환 형식은 JSON
     * @return ArticleListResponseDto(articles)
     */
    @GetMapping(value = "/lookup/v2", produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public GetArticleListDto lookUpArticlesV2(){
            List<Article> articles = articleService.LookupArticleV2();
            for(Article a: articles){
                System.out.println(a.getTitle());
                System.out.println(a.getWrited_date());
            }
            return new GetArticleListDto(articles);
        }

    /**
     * 메소드 명: lookUpArticlesV3()
     * 기능: lookUpArticlesV2()과 동일 하나, 사이트 별(다음, 네이버)로 기사 리스트를 불러옴
     * ArticleListResponseDto의 객체 형태로 반환 -> 반환 형식은 JSON
     * @return ArticleListResponseDto(articles)
     */
    @PostMapping("/lookup/v3/{site}")
    public GetArticleListDto lookUpArticlesV3(@PathVariable String site){
        System.out.println("[요청 사이트]: " + site);
        List<Article> articles = articleService.LookupArticleV3(site);
        return new GetArticleListDto(articles);
    }

    /**
     * 메소드 명: lookUpDetails
     * 기능: 특정 기사 선택 시 해당 기사에 대한 상세 내용, 작성자, 작성 일자 등의 정보와 댓글 목록을 조회하고
     *      해당 게시글의 조회수를 올리고 댓글들을 모두 조회함.
     * 반환 형식은 JSON
     * @param articleId
     * @return ArticleResponseDto(article, comments)
     */
    // 기사 상세보기
    @GetMapping("/lookup/details/{articleId}")
    public GetArticleDto lookUpDetails(@PathVariable int articleId){
        Article article = articleService.LookupDetails(articleId);
        articleService.LookupCount(articleId);
        List<Comment> comments = commentService.lookupComments(articleId);
        return new GetArticleDto(article, comments);
    }


}
