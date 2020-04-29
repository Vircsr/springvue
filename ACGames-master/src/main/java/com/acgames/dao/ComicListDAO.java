package com.acgames.dao;

import com.acgames.entity.ComicList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComicListDAO extends JpaRepository<ComicList,Integer> {
    ComicList findByComicName(String comicName);
    List<ComicList> findAllByOrderByLikesDesc();
    @Query(nativeQuery=true,value ="select * from comic_list order by likes desc limit 10")
    List<ComicList> findLikeTopTen();
}
