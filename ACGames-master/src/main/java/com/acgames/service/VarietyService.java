package com.acgames.service;

import com.acgames.dao.VarietyDAO;
import com.acgames.entity.Variety;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VarietyService {
    @Autowired
    VarietyDAO varietyDAO;

    public List<Variety> list() {
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return varietyDAO.findAll(sort);
    }

    public Variety get(int id) {
        Variety variety = varietyDAO.findById(id).orElse(null);
        return variety;
    }
}
