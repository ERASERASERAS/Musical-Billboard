package com.ssau.dao;

import com.ssau.model.Purchase;

import java.util.List;

public interface PurchaseDAO {
    int addPurchase(int id, int userId, int ticketId, int amount);

    Purchase getPurchaseById(int id);

    List<Purchase> getPurchasesForUser(int userId);
}
