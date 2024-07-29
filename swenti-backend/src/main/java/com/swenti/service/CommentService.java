package com.swenti.service;

import com.swenti.controller.dto.comment.CommentRequestDto;
import com.swenti.model.Comment;
import com.swenti.model.CommentsId;
import com.swenti.repository.CommentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentJpaRepository commentJpaRepository;

    // 몇 번째 댓글인지 알기 위해 댓글 수를 가져오는 메서드
    int findCommentid(int articleId){
        int commentid = commentJpaRepository.findCommentid(articleId);
        return commentid;
    }

    // 댓글 작성
    public void writeComment(CommentRequestDto body){
        int commentid = findCommentid(body.articleid());
        System.out.println("기사 번호: "+body.articleid());
        System.out.println("작성자: "+body.writer());
        System.out.println("내용: "+body.comment());

        CommentsId commentsId = new CommentsId(body.articleid(), commentid+1);
        Comment comment = new Comment(commentsId, body.writer(), body.comment());
        commentJpaRepository.save(comment);
    }

    @Transactional(readOnly = true)
    public List<Comment> lookupComments(int articleId){
        return commentJpaRepository.lookupComments(articleId);
    }

    public void deleteComment(int commentId){
        commentJpaRepository.deleteComment(commentId);
    }
}
