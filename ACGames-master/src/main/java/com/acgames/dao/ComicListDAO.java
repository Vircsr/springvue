package com.acgames.dao;

import com.acgames.entity.ComicList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComicListDAO extends JpaRepository<ComicList,Integer> {
    ComicList findByComicName(String comicName);
    List<ComicList> findAllByOrderByLikeDesc();
}
