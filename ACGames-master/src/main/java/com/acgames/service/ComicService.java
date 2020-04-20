package com.acgames.service;

import com.acgames.dao.ComicDAO;
import com.acgames.entity.Comic;
import com.acgames.entity.ComicList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicService {
    @Autowired
    ComicDAO comicDAO;
    @Autowired
    ComicListService comicListService;

    public List<Comic> listByComicList(int comic_list_id){
        ComicList comicList = comicListService.get(comic_list_id);
        return comicDAO.findAllByComicList(comicList);
    }
}
