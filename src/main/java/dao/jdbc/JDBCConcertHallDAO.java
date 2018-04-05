package dao.jdbc;

import dao.ConcertHallDAO;
import model.Concert;
import model.ConcertHall;

import java.util.List;

public class JDBCConcertHallDAO implements ConcertHallDAO {
    public ConcertHall getById(int id) {
        return new ConcertHall(1,"fdf", "fdf");
    }

    public List<ConcertHall> getAll() {
        return null;
    }

    public String getAddress(int id) {
        return null;
    }
}
