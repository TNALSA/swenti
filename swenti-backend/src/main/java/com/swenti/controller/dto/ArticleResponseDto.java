package com.swenti.controller.dto;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.swenti.model.Article;
@JsonInclude(value = JsonInclude.Include.NON_NULL) // json 형태로 만들어주는 annotation
public record ArticleResponseDto(List<Article> articles) {
}
