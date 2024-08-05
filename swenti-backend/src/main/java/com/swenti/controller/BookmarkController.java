package com.swenti.controller;

import com.swenti.controller.dto.bookmark.request.InsertBookmarkRequestDto;
import com.swenti.controller.dto.bookmark.request.SelectBookmarkRequestDto;
import com.swenti.controller.dto.bookmark.response.SelectBookmarkResponseDto;
import com.swenti.service.BookmarkService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @PostMapping("/setting/bookmark")
    public void setBookmark(@RequestBody InsertBookmarkRequestDto body){
        bookmarkService.setBookmark(body);
    }

    @DeleteMapping("/clear/bookmark/{articleid}/{userid}")
    public void clearBookmark(@PathVariable int articleid, @PathVariable String userid){
        bookmarkService.clearBookmark(articleid, userid);
    }

    @GetMapping("/isBookmark/{articleid}/{userid}")
    public boolean isBookmarked(@PathVariable int articleid, @PathVariable String userid){
       String result = bookmarkService.isBookmarked(articleid, userid);
       if(!result.equals("0")){
           return true;
       }
       return false;
    }
}
