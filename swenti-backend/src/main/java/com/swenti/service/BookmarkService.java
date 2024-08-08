package com.swenti.service;

import com.swenti.controller.dto.bookmark.request.SetBookmarkDto;
import com.swenti.model.Article;
import com.swenti.model.Bookmark;
import com.swenti.repository.BookmarkJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkJpaRepository bookmarkJpaRepository;

    @Transactional
    public void setBookmark(SetBookmarkDto body){
        String result = isBookmarked(body.articleid(), body.userid());
        if(!result.equals("0")){
            // Exception 처리
            System.out.println("[Error]: 이미 북마크 설정이 되어 있습니다.");
        } else {
            bookmarkJpaRepository.save(new Bookmark(body.articleid(), body.userid()));
        }
    }

    @Transactional
    public String isBookmarked(int articleid, String userid){
        return bookmarkJpaRepository.isBookmarked(articleid, userid);
    }

    @Transactional
    public void clearBookmark(int articleid, String userid){
        bookmarkJpaRepository.clearBookmark(articleid, userid);
    }

    @Transactional(readOnly = true)
    public List<Article> lookUpBookmark(String userid){
        return bookmarkJpaRepository.lookUpBookmark(userid);
    }
}
