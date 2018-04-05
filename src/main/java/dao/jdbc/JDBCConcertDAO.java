package dao.jdbc;

import dao.ConcertDAO;
import model.Concert;

import java.util.Date;
import java.util.List;

public class JDBCConcertDAO implements ConcertDAO {
    public Concert getById(int id) {
        return null;
    }

    public List<Concert> getConcertsBetweenDates(Date startDate, Date endDate) {
        return null;
    }

    public List<Concert> getComingConcerts() {
        return null;
    }

    public List<Concert> getConcertsByPriceRange(int minPrice, int maxPrice) {
        return null;
    }
}
