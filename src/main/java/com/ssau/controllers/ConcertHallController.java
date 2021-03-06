package com.ssau.controllers;

import com.ssau.dao.DAOFactory;

public class ConcertHallController {
    public String getAddress(int id) {
        return DAOFactory.getINSTANCE().getConcertHallDAO().getById(id).getAddress();
    }

    public int getIdByName(String name) {
        return DAOFactory.getINSTANCE().getConcertHallDAO().getByName(name).getId();
    }

    public String getName(int id) {
        return DAOFactory.getINSTANCE().getConcertHallDAO().getById(id).getName();
    }


}
