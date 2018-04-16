package com.ssau.dao;

import com.ssau.model.Artist;

public interface ArtistDAO {

    Artist getByName(String name);
    Artist getById(int id);


}
