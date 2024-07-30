package com.swenti.controller;

import com.swenti.controller.dto.comment.CommentRequestDto;
import com.swenti.model.Comment;
import com.swenti.service.ArticleService;
import com.swenti.service.CommentService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final List<Comment> comments;

    /**
     * 메서드 명: writeComment
     * 기능: 댓글 작성
     * RequestBody를 통해 전달 받은 댓글 내용을 DB에 저장한다.
     * @param body
     */
    @PostMapping("/comment/write")
    void writeComment(@RequestBody CommentRequestDto body){
        commentService.writeComment(body);
    }

    // 대댓글 작성 => 추후 작성
    //@PostMapping("/comment/write/sub")
    //void writeSubComment(@RequestBody CommentRequestDto body){
    //   commentService.writeSubComment(body);
    //}

    // 댓글 수정

    // 댓글 삭제
    @DeleteMapping("/comment/delete")
    void deleteComment(@RequestParam("commentId") int commentId){
        System.out.println("commentId = "+commentId);
        commentService.deleteComment(commentId);
    }
}
