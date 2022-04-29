package com.company.login;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import static com.company.dbhelper.DbConnection.getConnection;

public class Auth {
    //Authentication

    // Create a table called users that have the following fields with the following properties:
    // id -> serial, primary key
    // username -> varchar(255) unique
    // password -> varchar(255)
    // role -> varchar(255)

    // Write a method to sign up users on this student management platform,
    // that allows them to have a username and password and role.
    // The role is to be on of two items, (user and admin) (validate it such that anything else that
    // is entered is not passed tho the db).
    // Make the username unique as well on your table. (you can choose to make username an email instead).

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;

    public static boolean signUp() {

        System.out.print("Enter your username: ");
        String username = scanner.next();

        System.out.print("Enter your password: ");
        String password = scanner.next();

        System.out.print("Enter your role (user or admin): ");
        String role = scanner.next();


            if (role.equalsIgnoreCase("user") || role.equalsIgnoreCase("admin")) {
                try {
                    ps = getConnection().prepareStatement("INSERT INTO users(username, password, role) " +
                            "VALUES('" + username + "','" + password + "','" + role + "')");
                    ps.execute();
                    System.out.println("Username, password and role added");
                    return true;
                } catch (SQLException e) {
                    System.out.println("Not an unique username. Try another one.");
                    System.out.println(e.getMessage());
                    return false;
                }
            } else  {
                System.out.println("The " + role + " role is invalid. Accepted values are shown in the prompt.");
                return false;
            }


    }
}
