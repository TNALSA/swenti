package com.swenti.controller.dto.bookmark.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.swenti.model.Article;
import java.util.*;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record GetBookmarkListDto(List<Article> bookmarks) {
}
