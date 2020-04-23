package com.acgames.service;

import com.acgames.dao.VideoDAO;
import com.acgames.entity.User;
import com.acgames.entity.Variety;
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
    VarietyService varietyService;
    @Autowired
    UserService userService;

    public List<Video> list(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return videoDAO.findAll(sort);
    }

    public Video findById(int id) {
        return videoDAO.findById(id);
    }
    public void addOrUpdate(Video video){videoDAO.save(video);}

    public void deleteById(int id){videoDAO.deleteById(id);}

    public List<Video> listByVariety(int varid){
        Variety variety = varietyService.get(varid);
        return videoDAO.findAllByVariety(variety);
    }

    public List<Video> listByAuthid(int authid){
        return videoDAO.findAllByAuthid(authid);
    }
//    public List<Video> listByAuthor(String author){
//        return videoDAO.findAllByAuthor(author);
//    }

    public List<Video> Search(String keywords){
        return videoDAO.findAllByTitleLikeOrIntroductionLike('%'+keywords+'%','%'+keywords+'%');
    }
}
