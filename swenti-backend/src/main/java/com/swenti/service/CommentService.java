package com.swenti.service;

import com.swenti.controller.dto.comment.CommentRequestDto;
import com.swenti.model.Comment;
import com.swenti.repository.CommentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentJpaRepository commentJpaRepository;
    int findCommentid(){
        int commentid = commentJpaRepository.findCommentid();
        return commentid;
    }
    public void writeComment(CommentRequestDto body){
        int commentid = findCommentid();
        commentJpaRepository.save(new Comment(body.articleid(), commentid+1, body.writer(), body.comment()));
    }

    public void writeSubComment(CommentRequestDto body){

    }

}
