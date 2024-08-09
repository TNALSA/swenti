package com.swenti.controller;

import com.swenti.controller.dto.bookmark.request.SetBookmarkDto;

import com.swenti.controller.dto.bookmark.response.GetBookmarkListDto;
import com.swenti.model.Article;
import com.swenti.service.BookmarkService;

import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("bookmark")
public class BookmarkController {
    private final BookmarkService bookmarkService;

    /**
     * 북마크 설정
     * @param body
     */
    @PostMapping("/set")
    public void setBookmark(@RequestBody SetBookmarkDto body){
        bookmarkService.setBookmark(body);
    }

    /**
     * 북마크 설정 해제
     * @param articleid
     * @param userid
     */
    @DeleteMapping("/clear/{articleid}/{userid}")
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

    @GetMapping("/lookup")
    public GetBookmarkListDto lookUpBookmark(@RequestParam String userid){
        List<Article> bookmarks = bookmarkService.lookUpBookmark(userid);
        return new GetBookmarkListDto(bookmarks);
    }
}
