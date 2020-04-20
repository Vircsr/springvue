package com.acgames.service;

import com.acgames.dao.ComicListDAO;
import com.acgames.entity.ComicList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicListService {
    @Autowired
    ComicListDAO comicListDAO;

    public ComicList get(int id){
        ComicList comicList = comicListDAO.findById(id).orElse(null);
        return comicList;
    }

    public List<ComicList> listByLike(){
        return comicListDAO.findAllByOrderByLikeDesc();
    }

    public List<ComicList> topTenByLike(){
        Sort sort = Sort.by(Sort.Direction.DESC,"like");
        return comicListDAO.findAll(sort);
    }
//    public ComicList get(String name){
//        ComicList comicList = comicListDAO.findByComic_name(name);
//        return comicList;
//    }
}
