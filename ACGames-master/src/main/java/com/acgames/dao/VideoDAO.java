package com.acgames.dao;

import com.acgames.entity.User;
import com.acgames.entity.Variety;
import com.acgames.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoDAO extends JpaRepository<Video,Integer> {
    List<Video> findAllByVariety(Variety variety);
    Video findById(int id);
    List<Video> findAllByTitleLikeOrIntroductionLike(String keyword1,String keyword2);
}
