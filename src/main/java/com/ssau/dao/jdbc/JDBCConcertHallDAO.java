package com.ssau.dao.jdbc;

import com.ssau.dao.ConcertHallDAO;
import com.ssau.dao.DAOFactory;
import com.ssau.model.ConcertHall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCConcertHallDAO implements ConcertHallDAO {
    public ConcertHall getById(int id) {
        ConcertHall returned = null;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM concert_hall WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                returned = new ConcertHall(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(5), resultSet.getString(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returned;
    }

    public List<ConcertHall> getAll() {
        return null;
    }

    @Override
    public ConcertHall getByName(String name) {
        ConcertHall returned = null;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM concert_hall WHERE name = ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                returned = new ConcertHall(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(5), resultSet.getString(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returned;
    }

    public String getAddress(int id) {
        return null;
    }
}
