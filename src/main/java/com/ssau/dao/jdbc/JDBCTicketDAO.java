package com.ssau.dao.jdbc;

import com.ssau.dao.DAOFactory;
import com.ssau.dao.TicketDAO;
import com.ssau.model.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class JDBCTicketDAO implements TicketDAO {
    public Ticket getById(int id) {
        return null;
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
}
