package com.acgames.controller;

import com.acgames.result.Result;
import com.acgames.result.ResultFactory;
import com.acgames.service.ComicListService;
import com.acgames.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComicListController {
    @Autowired
    ComicListService comicListService;

    @GetMapping("/api/listbylike")
    public Result listComic() {
        return ResultFactory.buildSuccessResult(comicListService.listByLike());
    }

    @GetMapping("api/comiclist/topten")
    public Result topTen() {
        return ResultFactory.buildSuccessResult(comicListService.topTenByLike());
    }

    @GetMapping("/api/comiclist/{id}")
    public Result getList(@PathVariable("id") int id){
        return ResultFactory.buildSuccessResult(comicListService.get(id));
    }
}
