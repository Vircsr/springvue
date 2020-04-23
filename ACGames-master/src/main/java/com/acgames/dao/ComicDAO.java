package com.acgames.dao;

import com.acgames.entity.Comic;
import com.acgames.entity.ComicList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComicDAO extends JpaRepository<Comic,Integer> {
    List<Comic> findAllByComicListIdOrderBySectionIdAsc(int comicListId);
}
