package com.ssau.dao.jdbc;

import com.ssau.dao.ConcertDAO;
import com.ssau.dao.DAOFactory;
import com.ssau.model.Concert;

import java.sql.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class JDBCConcertDAO implements ConcertDAO {
    public Concert getById(int id) {
        Concert returnedConcert = null;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM concert WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                returnedConcert = new Concert(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                                                resultSet.getInt(4), resultSet.getDate(5), resultSet.getInt(7),resultSet.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedConcert;
    }

    public List<Concert> getConcertsBetweenDates(Date startDate, Date endDate) {
        List<Concert> returnedConcerts = new LinkedList<Concert>();
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM concert WHERE concert_date BETWEEN ? AND ?");
            preparedStatement.setDate(1, (java.sql.Date) startDate);
            preparedStatement.setDate(2, (java.sql.Date) endDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                returnedConcerts.add(new Concert(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                        resultSet.getInt(4), resultSet.getDate(5), resultSet.getInt(7),resultSet.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedConcerts;
    }

    public List<Concert> getComingConcerts() {
        return null;
    }

    public List<Concert> getConcertsByPriceRange(int minPrice, int maxPrice) {
        List<Concert> returnedConcerts = new LinkedList<Concert>();
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM concert c JOIN ticket t ON c.id = t.concert_id" +
                    "WHERE t.cost >= ? and t.cost <= ?");
            preparedStatement.setInt(1, minPrice);
            preparedStatement.setInt(2, maxPrice);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                returnedConcerts.add(new Concert(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                        resultSet.getInt(4), resultSet.getDate(5), resultSet.getInt(7),resultSet.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedConcerts;
    }

    @Override
    public List<Concert> getAll() {
        List<Concert> returned = new LinkedList<Concert>();
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM concert");
            while(resultSet.next()) {
                returned.add(new Concert(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                        resultSet.getInt(4), resultSet.getDate(5), resultSet.getInt(7), resultSet.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  returned;
    }

    @Override
    public List<Concert> getConcertsByDate(Date date) {
        return new LinkedList<Concert>();
    }

    @Override
    public List<Concert> getConcertByArtist(String artistName) {
        List<Concert> returnedConcerts = new LinkedList<Concert>();
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM concert c JOIN artist a ON c.artist_id = a.id WHERE a.name = ?");
            preparedStatement.setString(1, artistName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                returnedConcerts.add(new Concert(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                        resultSet.getInt(4), resultSet.getDate(5), resultSet.getInt(7),resultSet.getString(6)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedConcerts;
    }

    @Override
    public List<Concert> getConcertByConcertHall(int concertHallId) {
        List<Concert> returnedConcerts = new LinkedList<Concert>();
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM concert c " +
                    "JOIN concert_hall ch on c.concert_hall_id = ch.id WHERE ch.id = ?");
            preparedStatement.setInt(1, concertHallId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                returnedConcerts.add(new Concert(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                        resultSet.getInt(4), resultSet.getDate(5), resultSet.getInt(7),resultSet.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedConcerts;
    }
}
