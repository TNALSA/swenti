package com.swenti.repository;

import com.swenti.model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookmarkJpaRepository extends JpaRepository<Bookmark, Integer> {
    @Query("SELECT count(*) FROM Bookmark b WHERE b.articleid = :articleid AND b.userid = :userid")
    String isBookmarked(@Param("articleid") int articleid, @Param("userid") String userid);

    @Modifying
    @Query("DELETE FROM Bookmark b WHERE b.articleid = :articleid AND b.userid = :userid")
    void clearBookmark(@Param("articleid") int articleid, @Param("userid") String userid);

}
