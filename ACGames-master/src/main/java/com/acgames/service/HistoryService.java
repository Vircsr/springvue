package com.acgames.service;

import com.acgames.dao.HistoryDAO;
import com.acgames.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HistoryService {
    @Autowired
    HistoryDAO historyDAO;

    public List<History> listByUser(int userId){return historyDAO.findAllByUserIdOrderByHistoryTimeDesc(userId);}

    public List<History> listByVideo(int videoId){return historyDAO.findAllByVideoIdOrderByHistoryTimeDesc(videoId);}

    public void addOrUpdate(History history){historyDAO.save(history);}
}
