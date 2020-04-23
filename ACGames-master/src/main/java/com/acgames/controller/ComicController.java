package com.acgames.controller;

import com.acgames.entity.ComicList;
import com.acgames.result.Result;
import com.acgames.result.ResultFactory;
import com.acgames.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComicController {
    @Autowired
    ComicService comicService;

    @GetMapping("/api/comics/{comicListId}")
    public Result listByComicList (@PathVariable("comicListId") int comicListId){
        return ResultFactory.buildSuccessResult(comicService.listByComicList(comicListId));
    }
}
