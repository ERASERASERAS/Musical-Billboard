package com.ssau.dao.jdbc;

import com.ssau.dao.DAOFactory;
import com.ssau.dao.UserDAO;
import com.ssau.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class JDBCUserDAO implements UserDAO{
    @Override
    public User getUserByLogin(String login) {
        User returnedUser = null;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE login = ?");
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                returnedUser = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                                            resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedUser;
    }

    @Override
    public User getUserById(int id) {
        User returnedUser = null;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                returnedUser = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return returnedUser;
    }

    @Override
    public boolean addUser(int id, String login, String password, String role) {
        boolean result = true;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users VALUES(?,?,?,?)");
            statement.setInt(1, id);
            statement.setString(2, login);
            statement.setString(3, password);
            statement.setString(4, role);
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<User> getUsersByLoginPattern(String loginPattern) {
        List<User> returnedUsers = new LinkedList<User>();
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE login LIKE ?");
            statement.setString(1, loginPattern);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                returnedUsers.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  returnedUsers;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean result = true;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            statement.setInt(1, id);
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
