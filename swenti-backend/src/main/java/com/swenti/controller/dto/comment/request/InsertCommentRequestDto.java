package com.swenti.controller.dto.comment.request;

public record InsertCommentRequestDto(int articleid, String writer, String comment) {
}
