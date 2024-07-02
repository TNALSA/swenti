package com.swenti.controller.dto.article;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.swenti.model.Article;
import org.apache.el.stream.Optional;


@JsonInclude(value = JsonInclude.Include.NON_NULL) // json 형태로 만들어주는 annotation
public record ArticleResponseDto(Article article) {
}

