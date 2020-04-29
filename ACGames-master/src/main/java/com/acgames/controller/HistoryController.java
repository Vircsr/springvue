package com.acgames.controller;

import com.acgames.entity.History;
import com.acgames.result.Result;
import com.acgames.result.ResultFactory;
import com.acgames.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HistoryController {
    @Autowired
    HistoryService historyService;

    @GetMapping("/api/history/user")
    public Result listUserHistory(@RequestParam("userid") int userid){
        return ResultFactory.buildSuccessResult(historyService.listByUser(userid));
    }

    @GetMapping("/api/history/video")
    public Result listVideoHistory(@RequestParam("videoid") int videoid){
        return ResultFactory.buildSuccessResult(historyService.listByVideo(videoid));
    }

    @PostMapping("/api/history/add")
    public Result recordHistory(@RequestBody @Valid History history){
        historyService.addOrUpdate(history);
        return ResultFactory.buildSuccessResult("记录成功");
    }
}
