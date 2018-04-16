package com.ssau.controllers;

import com.ssau.dao.DAOFactory;
import com.ssau.model.Concert;

import java.util.Date;
import java.util.List;

public class ConcertController {
    public List<Concert> getConcertsByDate(Date date) {
        return DAOFactory.getINSTANCE().getConcertDAO().getConcertsByDate(date);
    }

    public List<Concert> getConcertsByArtist(String artistName) {
        return DAOFactory.getINSTANCE().getConcertDAO().getConcertByArtist(artistName);
    }

    public List<Concert> getConcertsByConcertHall(int concertHallId) {
        return DAOFactory.getINSTANCE().getConcertDAO().getConcertByConcertHall(concertHallId);
    }

}
