package com.ssau.dao;

import com.ssau.model.Concert;

import java.util.Date;
import java.util.List;

public interface ConcertDAO {

    Concert getById(int id);
    List<Concert> getConcertsBetweenDates(Date startDate, Date endDate);
    List<Concert> getComingConcerts();
    List<Concert> getConcertsByPriceRange(int minPrice, int maxPrice);
    List<Concert> getAll();
    List<Concert> getConcertsByDate(Date date);
    List<Concert> getConcertByArtist(String artistName);

    List<Concert> getConcertByConcertHall(int concertHallId) ;
}
