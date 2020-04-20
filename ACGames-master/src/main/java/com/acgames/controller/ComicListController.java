package com.acgames.controller;

import com.acgames.result.Result;
import com.acgames.result.ResultFactory;
import com.acgames.service.ComicListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComicListController {
    @Autowired
    ComicListService comicListService;

    @GetMapping("/api/comiclist")
    public Result listComic() {
        return ResultFactory.buildSuccessResult(comicListService.listByLike());
    }

    @GetMapping("api/comiclist/topten")
    public Result topTen() {
        return ResultFactory.buildSuccessResult(comicListService.topTenByLike());
    }
}
