package controllers;

import dao.DAOFactory;
import model.Concert;

import java.util.Date;
import java.util.List;

public class ConcertController {
    public List<Concert> getConcertsByDate(Date date) {
        return DAOFactory.getINSTANCE().getConcertDAO().getConcertsByDate(date);
    }

    public List<Concert> getConcertsByArtist(String artistName) {

    }

}
