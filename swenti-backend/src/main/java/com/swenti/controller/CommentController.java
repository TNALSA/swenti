package com.swenti.controller;

import com.swenti.controller.dto.comment.request.SetCommentDto;
import com.swenti.controller.dto.comment.response.DelCommentDto;
import com.swenti.message.ReturnMessage;
import com.swenti.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    /**
     * 메서드 명: writeComment
     * 기능: 댓글 작성
     * RequestBody를 통해 전달 받은 댓글 내용을 DB에 저장한다.
     * @param body
     */
    @PostMapping("/write")
    void writeComment(@RequestBody SetCommentDto body){
        commentService.writeComment(body);
    }

    /**
     * 메서드 명: deleteComment()
     * 기능: 댓글 삭제
     * RequestParam을 사용한 이유는 commentId 값 하나만 필요하기 때문에 굳이 Body로 받을 필요가 없을 것 같았다.
     * @param commentId
     */
    @DeleteMapping("/delete")
    DelCommentDto deleteComment(@RequestParam("commentId") int commentId){
        commentService.deleteComment(commentId);
        return new DelCommentDto(ReturnMessage.DEL_COMMENT.getComment());
    }
}
