package com.ssau.dao;

import com.ssau.model.PromotionGroup;

import java.util.List;

public interface PromotionGroupDAO {
    PromotionGroup getById(int id);
    PromotionGroup getByName(String name);
    List<PromotionGroup> getAll();
    int update(int id, String name, String telephone, String email);
    int add(String name, String telephone, String email);
    int delete(int id);
 }
