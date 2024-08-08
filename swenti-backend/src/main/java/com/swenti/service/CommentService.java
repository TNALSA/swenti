package com.swenti.service;

import com.swenti.controller.dto.comment.request.SetCommentDto;
import com.swenti.model.Comment;
import com.swenti.repository.CommentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentJpaRepository commentJpaRepository;

    /**
     * 메서드 명: findCommentid()
     * 기능: 해당 게시글에 대한 댓글 갯수를 조회
     * commentid -> increase로 변경하면 안되나??
     * @param articleId
     * @return commentid
     */
    int findCommentid(int articleId){
        int commentid = commentJpaRepository.findCommentid(articleId);
        return commentid;
    }

    /**
     * 메서드 명: writeComment()
     * 기능: 댓글 작성
     *
     * @param body
     */
    public void writeComment(SetCommentDto body){
        int commentid = findCommentid(body.articleid());
        System.out.println("기사 번호: "+body.articleid());
        System.out.println("작성자: "+body.writer());
        System.out.println("내용: "+body.comment());

        Comment comment = new Comment(body.articleid(),commentid+1, body.writer(), body.comment());
        commentJpaRepository.save(comment);
    }

    /**
     * 메서드 명: lookupComments()
     * 기능: 선택한 기사에 대한 댓글들을 모두 조회함.
     * @param articleId
     * @return List<Comment>
     */
    @Transactional(readOnly = true)
    public List<Comment> lookupComments(int articleId){
        return commentJpaRepository.lookupComments(articleId);
    }

    /**
     * 메서드 명: deleteComment()
     * 기능: CommentController와 이어지며, 댓글을 삭제
     * @param commentId
     */
    @Transactional
    public void deleteComment(int commentId){
        commentJpaRepository.deleteComment(commentId);
    }
}
