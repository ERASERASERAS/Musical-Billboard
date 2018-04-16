package com.ssau.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAOFactory {
    private static DAOFactory INSTANCE = new JDBCDAOFactory();

     DAOFactory() {}

    public static DAOFactory getINSTANCE() {
        return INSTANCE;
    }



    public abstract ArtistDAO getArtistDAO();

    public abstract ConcertDAO getConcertDAO();

    public abstract ConcertHallDAO getConcertHallDAO();

    public abstract PromotionGroupDAO getPromotionGroupDAO();

    public abstract TicketDAO getTicketDAO();

    public abstract  UserDAO getUserDAO();

    public abstract Connection getConnection() throws SQLException;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
