package com.swenti.controller.dto.comment.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record DelCommentDto(String comments) {
}
