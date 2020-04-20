package com.acgames.dao;

import com.acgames.entity.Variety;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VarietyDAO extends JpaRepository<Variety,Integer> {
}
