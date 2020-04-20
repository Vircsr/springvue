package com.acgames.controller;

import com.acgames.result.Result;
import com.acgames.result.ResultFactory;
import com.acgames.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VideoController {
    @Autowired
    VideoService videoService;

    @GetMapping("/api/videos")
    public Result listVideos(){ return ResultFactory.buildSuccessResult(videoService.list());}


    @GetMapping("/api/videos/search")
    public Result searchResult(@RequestParam("keywords") String keywords) {
        if ("".equals(keywords)) {
            return ResultFactory.buildSuccessResult(videoService.list());
        } else {
            return ResultFactory.buildSuccessResult(videoService.Search(keywords));
        }
    }

    @GetMapping("/api/varieties/{varid}/videos")
    public Result listByVariety(@PathVariable("varid") int varid){
        if(0 !=varid) {
            return ResultFactory.buildSuccessResult(videoService.listByVariety(varid));
        }else{
            return ResultFactory.buildSuccessResult(videoService.list());
        }
    }

    @GetMapping("/api/video/{id}")
    public Result playVideo(@PathVariable("id") int id){
        return ResultFactory.buildSuccessResult((videoService.findById(id)));
    }
}
