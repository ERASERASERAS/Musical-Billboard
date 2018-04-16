package com.ssau.dao.jdbc;

import com.ssau.dao.DAOFactory;
import com.ssau.dao.PromotionGroupDAO;
import com.ssau.model.PromotionGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPromotionGroupDAO implements PromotionGroupDAO {
    public PromotionGroup getById(int id) {
        PromotionGroup returned = null;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM promotion_group WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                returned = new PromotionGroup(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returned;
    }

    public PromotionGroup getByName(String name) {
        PromotionGroup returned = null;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM promotion_group WHERE name = ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                returned = new PromotionGroup(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returned;
    }
}
