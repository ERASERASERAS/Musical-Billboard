package dao;

import model.Concert;
import model.ConcertHall;

import java.util.List;

public interface ConcertHallDAO {
    ConcertHall getById(int id);
    List<ConcertHall>  getAll();
    ConcertHall getByName(String name);
    //todo  в concerthall u promogroup добавить поля контактных данных

}
