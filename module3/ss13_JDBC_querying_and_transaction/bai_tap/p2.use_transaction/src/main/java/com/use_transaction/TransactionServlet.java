package com.use_transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "TransactionServlet", value = "/")
public class TransactionServlet extends HttpServlet {
    public class Servlet extends HttpServlet {
        private String jdbcURL = "jdbc:mysql://localhost:3306/demoss12";
        private String jdbcUsername = "root";
        private String jdbcPassword = "12345678";
        private final String Q1 = "insert into users (name, email, country) values(?,?,?)";
        private final String Q2 = "insert into users (id, name, email, country) values(?,?,?,?)";
        private Connection getConnection(){
            Connection connection=null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection=DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return connection;
        }
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Savepoint savepoint = null;
            Connection connection=getConnection();
            try {
                connection.setAutoCommit(false);
                PreparedStatement stm1=null;
                stm1 = connection.prepareStatement(Q1);
                stm1.setString(1, "1");
                stm1.setString(2, "2");
                stm1.setString(3, "3");
                stm1.executeUpdate();
                savepoint = connection.setSavepoint();
                stm1 = connection.prepareStatement(Q2);
                stm1.setString(1, "2");
                stm1.setString(1, "1");
                stm1.setString(2, "2");
                stm1.setString(3, "3");
                stm1.executeUpdate();

                connection.commit();
                stm1.close();
            }catch (SQLException e){
                e.printStackTrace();
                try {
                    connection.rollback(savepoint);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            finally {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
