package com.example.user.dao;

import com.example.user.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user);
    public User selectUser(int id);
    public List<User> selectAllUser();
    public boolean deleteUser(int id);
    public boolean updateUser(User user) throws SQLException;
    public List<User> findUser(String s);
}
