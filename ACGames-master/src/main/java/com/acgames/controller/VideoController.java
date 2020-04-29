package com.acgames.controller;

import com.acgames.entity.ComicList;
import com.acgames.entity.Video;
import com.acgames.result.Result;
import com.acgames.result.ResultFactory;
import com.acgames.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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


    @GetMapping("/api/video/{id}")
    public Result playVideo(@PathVariable("id") int id){
        return ResultFactory.buildSuccessResult(videoService.findById(id));
    }

    @GetMapping("/api/videos/{authid}")
    public Result listByAuthid(@PathVariable("authid") int authid){
        return ResultFactory.buildSuccessResult(videoService.listByAuthid(authid));
    }

    @GetMapping("api/videos/{userid}/recommend")
    public Result recommend(@PathVariable("userid") int userid){
        return ResultFactory.buildSuccessResult(videoService.videoRecommends());
    }

    @PostMapping("/api/video/hits")
    public Result addOrUpdateGrade(@RequestBody @Valid Video video) {
        int id = video.getId();
        Video videoinfo = videoService.findById(id);
        int hits = videoinfo.getHits();
        videoinfo.setHits(++hits);
        videoService.addOrUpdate(videoinfo);
        return ResultFactory.buildSuccessResult("修改成功");
    }
}
