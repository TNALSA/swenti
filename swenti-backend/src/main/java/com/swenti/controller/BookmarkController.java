package com.swenti.controller;

import com.swenti.controller.dto.bookmark.request.InsertBookmarkRequestDto;

import com.swenti.controller.dto.bookmark.response.SelectBookmarkListResponseDto;
import com.swenti.model.Article;
import com.swenti.service.BookmarkService;
import lombok.Getter;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService bookmarkService;

    /**
     * 북마크 설정
     * @param body
     */
    @PostMapping("/setting/bookmark")
    public void setBookmark(@RequestBody InsertBookmarkRequestDto body){
        bookmarkService.setBookmark(body);
    }

    /**
     * 북마크 설정 해제
     * @param articleid
     * @param userid
     */
    @DeleteMapping("/clear/bookmark/{articleid}/{userid}")
    public void clearBookmark(@PathVariable int articleid, @PathVariable String userid){
        bookmarkService.clearBookmark(articleid, userid);
    }

    /**
     * 북마크 설정 여부 확인
     * @param articleid
     * @param userid
     * @return
     */
    @GetMapping("/isBookmark/{articleid}/{userid}")
    public boolean isBookmarked(@PathVariable int articleid, @PathVariable String userid){
       String result = bookmarkService.isBookmarked(articleid, userid);
       if(!result.equals("0")){
           return true;
       }
       return false;
    }

    @GetMapping("lookup/bookmark")
    public SelectBookmarkListResponseDto lookUpBookmark(@RequestParam String userid){
        List<Article> bookmarks = bookmarkService.lookUpBookmark(userid);
        return new SelectBookmarkListResponseDto(bookmarks);
    }
}
