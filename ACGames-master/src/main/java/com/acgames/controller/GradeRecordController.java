package com.acgames.controller;

import com.acgames.entity.GradeRecord;
import com.acgames.result.Result;
import com.acgames.result.ResultFactory;
import com.acgames.service.GradeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class GradeRecordController {
    @Autowired
    GradeRecordService gradeRecordService;

    @PostMapping("/api/video/grade")
    public Result addOrUpdateGrade(@RequestBody @Valid GradeRecord gradeRecord) {
        int userid = gradeRecord.getUserId();
        int videoid = gradeRecord.getVideoId();
        GradeRecord record = gradeRecordService.findGrade(userid, videoid);
        if(record == null){
            gradeRecordService.addOrUpdate(gradeRecord);
            return ResultFactory.buildSuccessResult("创建成功");
        }else{
            record.setGrade(gradeRecord.getGrade());
            record.setCreateTime(gradeRecord.getCreateTime());
            gradeRecordService.keepGrade(record);
            return ResultFactory.buildSuccessResult("修改成功");
        }
    }

}
