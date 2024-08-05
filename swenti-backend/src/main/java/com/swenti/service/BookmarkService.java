package com.swenti.service;

import com.swenti.controller.dto.bookmark.request.InsertBookmarkRequestDto;
import com.swenti.controller.dto.bookmark.request.SelectBookmarkRequestDto;
import com.swenti.model.Bookmark;
import com.swenti.repository.BookmarkJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkJpaRepository bookmarkJpaRepository;

    @Transactional
    public void setBookmark(InsertBookmarkRequestDto body){
        String result = isBookmarked(body.articleid(), body.userid());
        if(!result.equals("0")){
            // Exception 처리
            System.out.println("[Error]: 이미 북마크 설정이 되어 있습니다.");
        } else {
            Bookmark bookmark = new Bookmark(body.articleid(), body.userid());
            bookmarkJpaRepository.save(bookmark);
        }
    }

    @Transactional
    public String isBookmarked(int articleid, String userid){
        String result = bookmarkJpaRepository.isBookmarked(articleid, userid);
        System.out.println("[결과]: " + result);
        return result;
    }

    @Transactional
    public void clearBookmark(int articleid, String userid){
        bookmarkJpaRepository.clearBookmark(articleid, userid);
    }
}
