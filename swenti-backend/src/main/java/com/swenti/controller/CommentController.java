package com.swenti.controller;

import com.swenti.controller.dto.comment.CommentRequestDto;
import com.swenti.model.Comment;
import com.swenti.service.ArticleService;
import com.swenti.service.CommentService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final List<Comment> comments;
    // 댓글 작성
    @PostMapping("/comment/write")
    void writeComment(@RequestBody CommentRequestDto body){
        commentService.writeComment(body);
    }

    // 대댓글 작성
//    @PostMapping("/comment/write/sub")
//    void writeSubComment(@RequestBody CommentRequestDto body){
//        commentService.writeSubComment(body);
//    }

    // 댓글 수정

    // 댓글 삭제

}