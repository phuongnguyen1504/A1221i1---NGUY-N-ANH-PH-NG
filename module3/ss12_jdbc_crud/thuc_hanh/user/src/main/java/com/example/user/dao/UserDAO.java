package com.example.user.dao;

import com.example.user.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO{
    private static final String INSERT_USER_SQL = "INSERT INTO users"+" (name,email,country) VALUES "+"(?,?,?);";
    private static final String SELECT_USER_BY_ID = "SELECT id,name,email,country FROM users where id=?;";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users;";
    private static final String DELETE_USERS_SQL="DELETE FROM users where id=?;";
    private static final String UPDATE_USERS_SQL="UPDATE users set name=?,email=?,country=? WHERE id=?;";
    private String jdbcURL = "jdbc:mysql://localhost:3306/demoss12?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    public UserDAO() {
    }
    protected Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    };

    @Override
    public void insertUser(User user) {
        System.out.println(INSERT_USER_SQL);
        try(Connection connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USER_SQL)){
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User selectUser(int id) {
        User user=null;
        try(Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(SELECT_USER_BY_ID);){
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                String name=rs.getString("name");
                String email=rs.getString("email");
                String country=rs.getString("country");
                user=new User(id,name,email,country);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        ResultSet rs=null;
        List<User> list=new ArrayList<>();
        try(Connection connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_USERS)){
            System.out.println(SELECT_ALL_USERS);
            rs= preparedStatement.executeQuery();
            while (rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String email=rs.getString("email");
                String country=rs.getString("country");
                list.add(new User(id,name,email,country));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean rowDelete;
        try(Connection connection=getConnection();
            PreparedStatement statement=connection.prepareStatement(DELETE_USERS_SQL)){
            statement.setInt(1,id);
            rowDelete=statement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDelete;
    }

    @Override
    public boolean updateUser(User user) throws SQLException{
        boolean rowUpdate;
        try(Connection connection=getConnection();
            PreparedStatement statement=connection.prepareStatement(UPDATE_USERS_SQL)){
            statement.setString(1,user.getName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getCountry());
            statement.setInt(4,user.getId());
            rowUpdate=statement.executeUpdate()>0;
        }
        return rowUpdate;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
