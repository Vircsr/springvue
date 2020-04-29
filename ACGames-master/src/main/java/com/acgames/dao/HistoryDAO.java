package com.acgames.dao;

import com.acgames.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryDAO extends JpaRepository<History, Integer> {
    List<History> findAllByUserIdOrderByHistoryTimeDesc(int userId);
    List<History> findAllByVideoIdOrderByHistoryTimeDesc(int videoId);
}
