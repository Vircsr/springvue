package com.acgames.dao;

import com.acgames.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoDAO extends JpaRepository<Video,Integer> {
    List<Video> findAllByAuthid(int authid);

    @Query(nativeQuery=true,value ="select * from video order by hits desc limit 6")
    List<Video> findLikeTopTen();

    Video findById(int id);
    List<Video> findAllByTitleLikeOrIntroductionLike(String keyword1,String keyword2);
}
