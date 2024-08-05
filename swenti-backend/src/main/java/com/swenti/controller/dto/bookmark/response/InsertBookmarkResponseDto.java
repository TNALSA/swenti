package com.swenti.controller.dto.bookmark.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record InsertBookmarkResponseDto(String comments) {
}
