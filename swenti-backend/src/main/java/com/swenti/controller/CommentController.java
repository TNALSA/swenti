package com.swenti.controller;

import com.swenti.controller.dto.comment.request.InsertCommentRequestDto;
import com.swenti.controller.dto.comment.response.DeleteCommentResponseDto;
import com.swenti.message.ReturnMessage;
import com.swenti.model.Comment;
import com.swenti.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    /**
     * 메서드 명: writeComment
     * 기능: 댓글 작성
     * RequestBody를 통해 전달 받은 댓글 내용을 DB에 저장한다.
     * @param body
     */
    @PostMapping("/comment/write")
    void writeComment(@RequestBody InsertCommentRequestDto body){
        commentService.writeComment(body);
    }

    /**
     * 메서드 명: deleteComment()
     * 기능: 댓글 삭제
     * RequestParam을 사용한 이유는 commentId 값 하나만 필요하기 때문에 굳이 Body로 받을 필요가 없을 것 같았다.
     * @param commentId
     */
    @DeleteMapping("/comment/delete")
    DeleteCommentResponseDto deleteComment(@RequestParam("commentId") int commentId){
        System.out.println("[삭제 댓글]: " + commentId);
        commentService.deleteComment(commentId);
        return new DeleteCommentResponseDto(ReturnMessage.DEL_COMMENT.getComment());
    }
}
