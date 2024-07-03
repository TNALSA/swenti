package com.swenti.controller.dto.article;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.swenti.model.Article;

import java.util.List;
@JsonInclude(value = JsonInclude.Include.NON_NULL) // json 형태로 만들어주는 annotation
public record ArticleListResponseDto(List<Article> articles) {

}
