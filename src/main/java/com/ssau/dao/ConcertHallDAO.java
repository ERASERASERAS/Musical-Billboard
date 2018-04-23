package com.ssau.dao;

import com.ssau.model.ConcertHall;

import java.util.List;

public interface ConcertHallDAO {
    ConcertHall getById(int id);
    List<ConcertHall>  getAll();
    ConcertHall getByName(String name);


}
