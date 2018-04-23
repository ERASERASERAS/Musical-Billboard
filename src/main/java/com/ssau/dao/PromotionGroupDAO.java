package com.ssau.dao;

import com.ssau.model.PromotionGroup;

import java.util.List;

public interface PromotionGroupDAO {
    PromotionGroup getById(int id);
    PromotionGroup getByName(String name);
    List<PromotionGroup> getAll();
 }
