package com.company.login;

import com.company.objects.Password;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import static com.company.dbhelper.DbConnection.getConnection;

public class Auth {
    /*//Authentication

    // Create a table called users that have the following fields with the following properties:
    // id -> serial, primary key
    // username -> varchar(255) unique
    // password -> varchar(255)
    // role -> varchar(255)*/

    // Write a method to sign up users on this student management platform,
    // that allows them to have a username(make unique) and password and role.
    // The role is to be on of two items, (user and admin) (validate it such that anything else that
    // is entered is not passed tho the db). (you can choose to make username an email instead).

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean signUp() {
        System.out.print("Sign up! Enter your username: ");
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
        } else {
            System.out.println("The " + role + " role is invalid. Accepted values are shown in the prompt.");
            return false;
        }
    }
    // Create a login() method like we discussed for the Auth class that returns a
    // Boolean for when a username and password that exists in the database is entered.

    public static boolean login() {
        System.out.print("Log in! Enter your username: ");
        String username = scanner.next();

        System.out.print("Enter your password: ");
        String password = scanner.next();

        Password psw = new Password();
        try {
            //SELECT password FROM users WHERE password IN ('');
            ps = getConnection().prepareStatement("SELECT username, password FROM users " +
                    "WHERE password IN('" + username + "','" + password + "')");
            rs = ps.executeQuery();

            String password2, username2;

            while (rs.next()) {
                username2 = rs.getString("username");
                password2 = rs.getString("password");

                psw.setUsername();
                psw.setPassword();

                if (password2.equals(password) && username2.equalsIgnoreCase(username)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
