package com.swenti.repository;

import com.swenti.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;


public interface CommentJpaRepository extends JpaRepository<Comment, Integer> {
    @Query("SELECT COUNT(*) FROM Comment c WHERE c.commentlevel = 0")
    int findCommentid();

    @Query("SELECT c FROM Comment c WHERE c.articleid = :articleId")
    List<Comment> lookupComments(@Param("articleId") int articleId);

}
