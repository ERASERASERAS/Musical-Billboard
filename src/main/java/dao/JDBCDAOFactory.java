package dao;

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

    public ArtistDAO getArtistDAO() {
        return null;
    }

    public static Connection getConnection() throws SQLException {
       return  dataSource.getConnection();
    }

    public ConcertDAO getConcertDAO() {
        return null;
    }

    public ConcertHallDAO getConcertHallDAO() {
        return null;
    }

    public PromotionGroupDAO getPromotionGroupDAO() {
        return null;
    }

    public TicketDAO getTicketDAO() {
        return null;
    }
}
