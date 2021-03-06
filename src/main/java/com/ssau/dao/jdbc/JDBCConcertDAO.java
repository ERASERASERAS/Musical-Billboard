package com.ssau.dao.jdbc;

import com.ssau.dao.ConcertDAO;
import com.ssau.dao.DAOFactory;
import com.ssau.model.Concert;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                                                new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(resultSet.getTimestamp(4).toString().substring(0,16)) , resultSet.getString(5), resultSet.getInt(6),resultSet.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
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
                        resultSet.getDate(4), resultSet.getString(5), resultSet.getInt(6),resultSet.getString(7)));
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
                        resultSet.getDate(4), resultSet.getString(5), resultSet.getInt(6),resultSet.getString(7)));
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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM concert ORDER BY id ASC");
            while(resultSet.next()) {
                returned.add(new Concert(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                        resultSet.getDate(4), resultSet.getString(5), resultSet.getInt(6),resultSet.getString(7)));;
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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM concert WHERE artist = ?");
            preparedStatement.setString(1, artistName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                returnedConcerts.add(new Concert(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                        resultSet.getDate(4), resultSet.getString(5), resultSet.getInt(6),resultSet.getString(7)));
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
                        resultSet.getDate(4), resultSet.getString(5), resultSet.getInt(6),resultSet.getString(7)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedConcerts;
    }

    @Override
    public int update(int id, int concertHallId, int promoGroupId, Date date, String description, int ageConstraint, String artist) {
        int result = 0;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE concert SET concert_hall_id = ?, promotion_group_id = ?," +
                    "concert_date = ?, descriprion = ?, age_constraint = ?, artist = ? WHERE id = ?");
            preparedStatement.setInt(1, concertHallId);
            preparedStatement.setInt(2, promoGroupId);
            preparedStatement.setTimestamp(3, new Timestamp(date.getTime()));
            preparedStatement.setString(4, description);
            preparedStatement.setInt(5, ageConstraint);
            preparedStatement.setString(6, description);
            preparedStatement.setInt(7, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(int id) {
        int result = 0;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM concert WHERE id=?");
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int add(int promoGroupId, int concertHallId, int ageConstraint, String artist, Date date, String description) {
        int result = 0;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO concert VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, getAll().size() + 1);
            preparedStatement.setInt(2, concertHallId);
            preparedStatement.setInt(3, promoGroupId);
            preparedStatement.setTimestamp(4, new Timestamp(date.getTime()));
            preparedStatement.setString(5, description);
            preparedStatement.setInt(6, ageConstraint);
            preparedStatement.setString(7, artist);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
