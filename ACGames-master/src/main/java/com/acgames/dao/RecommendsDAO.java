package com.acgames.dao;

import com.acgames.entity.Recommends;
import com.acgames.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecommendsDAO extends JpaRepository<Recommends,Integer> {
    @Query(nativeQuery=true,value ="select * from recommends order by id desc limit 6")
    List<Recommends> recommends();
}
