package com.acgames.dao;

import com.acgames.entity.GradeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRecordDAO extends JpaRepository<GradeRecord,Integer> {
    GradeRecord findByUserIdAndVideoId(int userId, int videoId);
}
