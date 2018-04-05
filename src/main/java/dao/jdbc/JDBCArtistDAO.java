package dao.jdbc;

import dao.ArtistDAO;
import dao.JDBCDAOFactory;
import model.Artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCArtistDAO implements ArtistDAO {
    public Artist getByName(String name) {
        return null;
    }

    public Artist getById(int id) {
        Artist returnedArtist = null;
        try(Connection connection = JDBCDAOFactory.getConnection()) {
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
