package dao;

import model.Artist;

public interface ArtistDAO {

    Artist getByName(String name);
    Artist getById(int id);


}
