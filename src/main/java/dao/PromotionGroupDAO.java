package dao;

import model.PromotionGroup;

public interface PromotionGroupDAO {
    PromotionGroup getById(int id);
    PromotionGroup getByName(String name);
}
