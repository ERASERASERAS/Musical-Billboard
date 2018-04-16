package com.ssau.dao;

import com.ssau.model.User;

import java.util.List;

public interface UserDAO {
    User getUserByLogin(String name);
    User getUserById(int id);
    boolean addUser(int id, String login, String password, String role);
    List<User> getUsersByLoginPattern(String loginPattern) ;
    boolean deleteUser(int id);
}
