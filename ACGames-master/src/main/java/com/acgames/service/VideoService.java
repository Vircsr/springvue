package com.acgames.service;

import com.acgames.dao.RecommendsDAO;
import com.acgames.dao.VideoDAO;
import com.acgames.entity.Recommends;
import com.acgames.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    @Autowired
    VideoDAO videoDAO;
    @Autowired
    UserService userService;
    @Autowired
    RecommendsDAO recommendsDAO;

    public List<Video> list(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return videoDAO.findAll(sort);
    }

    public Video findById(int id) {
        return videoDAO.findById(id);
    }
    public void addOrUpdate(Video video){videoDAO.save(video);}

    public void deleteById(int id){videoDAO.deleteById(id);}

    public List<Video> listByAuthid(int authid){
        return videoDAO.findAllByAuthid(authid);
    }

    public List<Video> topTenByLike(){
        List<Video> list = videoDAO.findLikeTopTen();
        return list;
    }

    public List<Recommends> videoRecommends(){
        List<Recommends> list = recommendsDAO.recommends();
        return list;
    }

    public List<Video> Search(String keywords){
        return videoDAO.findAllByTitleLikeOrIntroductionLike('%'+keywords+'%','%'+keywords+'%');
    }
}
