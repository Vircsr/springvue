package com.acgames.service;

import com.acgames.dao.GradeRecordDAO;
import com.acgames.entity.GradeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeRecordService {
    @Autowired
    GradeRecordDAO gradeRecordDAO;

    public void addOrUpdate(GradeRecord gradeRecord) {
        gradeRecordDAO.save(gradeRecord);
    }
    public GradeRecord findGrade(int userId, int videoId) {
        return gradeRecordDAO.findByUserIdAndVideoId(userId, videoId);
    }
    public void keepGrade(GradeRecord gradeRecord){
        gradeRecordDAO.save(gradeRecord);
    }
}
