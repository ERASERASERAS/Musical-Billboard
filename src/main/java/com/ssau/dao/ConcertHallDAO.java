package com.ssau.dao;

import com.ssau.model.ConcertHall;

import java.util.List;

public interface ConcertHallDAO {
    ConcertHall getById(int id);
    List<ConcertHall>  getAll();
    ConcertHall getByName(String name);
    int update(int id, String name, String address, String telephone, String email);
    int add(String name, String address, String telephone, String email);
    int delete(int id);

}
