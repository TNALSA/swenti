package com.swenti.controller.dto.article.response;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.swenti.model.Article;
import com.swenti.model.Comment;

@JsonInclude(value = JsonInclude.Include.NON_NULL ) // json 형태로 만들어주는 annotation
public record SelectArticleResponseDto(Article article, List<Comment> comments) {}
