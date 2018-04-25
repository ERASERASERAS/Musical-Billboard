package com.ssau.dao.jdbc;

import com.ssau.dao.DAOFactory;
import com.ssau.dao.PromotionGroupDAO;
import com.ssau.model.PromotionGroup;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

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

    @Override
    public List<PromotionGroup> getAll() {
        List<PromotionGroup> promotionGroups = new LinkedList<PromotionGroup>();
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM promotion_group");
            while(resultSet.next()) {
                promotionGroups.add(new PromotionGroup(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotionGroups;
    }

    @Override
    public int update(int id, String name, String telephone, String email) {
        int result = 0;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE promotion_group " +
                    "SET name=?, email=?, telephone=? WHERE id=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, telephone);
            preparedStatement.setString(3, email);
            preparedStatement.setInt(4, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  result;
    }

    @Override
    public int add(String name, String telephone, String email) {
        int result = 0;
        try(Connection connection = DAOFactory.getINSTANCE().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO promotion_group VALUES (?,?,?,?)");
            preparedStatement.setInt(1, getAll().size() + 1);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4, telephone);
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
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM promotion_group WHERE id=?");
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
