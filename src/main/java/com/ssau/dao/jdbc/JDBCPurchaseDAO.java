package com.ssau.dao.jdbc;

import com.ssau.dao.DAOFactory;
import com.ssau.dao.PurchaseDAO;
import com.ssau.model.Purchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class JDBCPurchaseDAO implements PurchaseDAO{

    @Override
    public int addPurchase(int id, int userId, int ticketId, int amount) {
        int result = 0;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO purchases VALUES(?,?,?,?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2,userId);
            preparedStatement.setInt(3, ticketId);
            preparedStatement.setInt(4, amount);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Purchase getPurchaseById(int id) {
        Purchase returned = null;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM purchases WHEN  id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                returned = new Purchase(resultSet.getInt(1), resultSet.getInt(2),resultSet.getInt(3), resultSet.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returned;
    }

    @Override
    public List<Purchase> getPurchasesForUser(int userId) {
        List<Purchase> returned = new LinkedList<Purchase>();
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM purchases WHEN  user_id = ?");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                returned.add(new Purchase(resultSet.getInt(1), resultSet.getInt(2),resultSet.getInt(3), resultSet.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returned;
    }
}