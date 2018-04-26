package com.ssau.dao.jdbc;

import com.ssau.dao.DAOFactory;
import com.ssau.dao.TicketDAO;
import com.ssau.model.Ticket;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class JDBCTicketDAO implements TicketDAO {
    public Ticket getById(int id) {
        Ticket returned = null;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ticket WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                returned = new Ticket(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(4),
                        resultSet.getString(3), resultSet.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returned;
    }



    public List<Ticket> getTicketsByConcert(int concertId) {
        List<Ticket> returned = new LinkedList<Ticket>();
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ticket WHERE concert_id = ?");
            preparedStatement.setInt(1, concertId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                returned.add(new Ticket(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(4),
                                            resultSet.getString(3), resultSet.getInt(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returned;
    }

    public List<String> getAllTicketsCategories(int concertId) {
        return null;
    }

    @Override
    public int updateAmount(int ticketId, int newAmount) {
        int result = 0;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ticket SET amount=? WHERE id=?");
            preparedStatement.setInt(1, newAmount);
            preparedStatement.setInt(2, ticketId);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(int ticketId,  String category, int cost, int amount) {
        int result = 0;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ticket SET " +
                    "category=?,cost=?,amount=? WHERE id=?");
            preparedStatement.setString(1, category);
            preparedStatement.setInt(2, cost);
            preparedStatement.setInt(3, amount);
            preparedStatement.setInt(4, ticketId);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int add(int concertId, String category, int cost, int amount) {
        int result = 0;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ticket VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, getAll().size() + 1);
            preparedStatement.setInt(2, concertId);
            preparedStatement.setString(3, category);
            preparedStatement.setInt(4, cost);
            preparedStatement.setInt(5, amount);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Ticket> getAll() {
        List<Ticket> tickets = new LinkedList<Ticket>();
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ticket");
            while(resultSet.next()) {
                tickets.add(new Ticket(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(4),
                        resultSet.getString(3), resultSet.getInt(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }
    @Override
    public int delete(int id) {
        int result = 0;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ticket WHERE id=?");
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteByConcertId(int concertId) {
        int result = 0;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ticket WHERE concert_id=?");
            preparedStatement.setInt(1, concertId);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
