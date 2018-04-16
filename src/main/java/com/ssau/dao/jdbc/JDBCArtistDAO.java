package com.ssau.dao.jdbc;

import com.ssau.dao.ArtistDAO;
import com.ssau.dao.DAOFactory;
import com.ssau.model.Artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCArtistDAO implements ArtistDAO {
    public Artist getByName(String name) {
        Artist returnedArtist = null;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM artist WHERE name = ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                returnedArtist = new Artist(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedArtist;
    }

    public Artist getById(int id) {
        Artist returnedArtist = null;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM artist WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                returnedArtist = new Artist(resultSet.getInt(1), resultSet.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedArtist;
    }
}
