package com.swenti.repository;

import com.swenti.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


public interface CommentJpaRepository extends JpaRepository<Comment, Integer> {
    //@Query("SELECT COUNT(*) FROM Comment c WHERE c.id.aticleid = :articleId AND c.commentlevel = 0")
    @Query("SELECT COUNT(*) FROM Comment c WHERE c.articleid = :articleId AND c.commentlevel = 0")
    int findCommentid(@Param("articleId") int articleId);

    //@Query("SELECT c FROM Comment c WHERE c.id.aticleid = :articleId")
    @Query("SELECT c FROM Comment c WHERE c.articleid = :articleId")
    List<Comment> lookupComments(@Param("articleId") int articleId);

    //@Query("DELETE FROM Comment c WHERE c.id.commentid = :commentId")
    @Modifying
    @Query("DELETE FROM Comment c WHERE c.commentid = :commentId")
    void deleteComment(@Param("commentId") int commentId);

}
