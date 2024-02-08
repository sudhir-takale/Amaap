package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {


        String url = "jdbc:mysql://localhost:3306/demo";
        String username = "root";
        String password = "root";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully");

            Statement statement = connection.createStatement();
            int result = statement.executeUpdate("insert into info values (3, 'Shaurya Mali', 'Sangola', 'Shaurya@12')");

            System.out.println("Query executed successfully " + result);
            connection.close();

        } catch (SQLException e) {

            throw new SQLException("Failed to connect");


        }
    }

}