package com.company.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    // create one static method to return the connection to database
    // via the jdbc. it is static method because we do not need multiple
    // connections or instances to the database

    public static Connection getConnection() {
            Connection connection = null;

            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/students", "postgres", "123");
//                if (connection != null) System.out.println("Connection successful");
            } catch (SQLException e) {
                System.out.println("There was a problem connecting to database");
                e.printStackTrace();
            }
            return connection;

        }

}


