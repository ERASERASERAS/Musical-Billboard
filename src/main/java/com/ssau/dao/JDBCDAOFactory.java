package com.ssau.dao;

import com.ssau.dao.jdbc.*;
import org.postgresql.ds.PGPoolingDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDAOFactory extends DAOFactory{

    private static PGPoolingDataSource dataSource;

    JDBCDAOFactory() {
        dataSource = new PGPoolingDataSource();
        dataSource.setDataSourceName("musical_billboard");
        dataSource.setServerName("localhost");
        dataSource.setDataSourceName("musical_billboardDS");
        dataSource.setDatabaseName("musical_billboard");
        dataSource.setUser("postgres");
        dataSource.setPassword("eras1996wwbpo");
        dataSource.setMaxConnections(10);

    }



    public  Connection getConnection() throws SQLException {
       return  dataSource.getConnection();
    }

    public ConcertDAO getConcertDAO() {
        return new JDBCConcertDAO();
    }

    public ConcertHallDAO getConcertHallDAO() {
        return new JDBCConcertHallDAO();
    }

    public PromotionGroupDAO getPromotionGroupDAO() {
        return new JDBCPromotionGroupDAO();
    }

    public TicketDAO getTicketDAO() {
        return new JDBCTicketDAO();
    }

    public UserDAO getUserDAO() {
        return new JDBCUserDAO();
    }


    public PurchaseDAO getPurchaseDAO() {
        return new JDBCPurchaseDAO();
    }
}
