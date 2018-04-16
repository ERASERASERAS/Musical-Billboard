package com.ssau.dao;

import com.ssau.model.PromotionGroup;

public interface PromotionGroupDAO {
    PromotionGroup getById(int id);
    PromotionGroup getByName(String name);
}
