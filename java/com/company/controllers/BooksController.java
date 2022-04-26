package com.company.controllers;

import com.company.objects.Books;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import static com.company.dbhelper.DbConnection.getConnection;

public class BooksController {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addBook() {

        System.out.print("Enter the name of the book: ");
        String name = scanner.next();

        System.out.print("Enter the price of the book: ");
        String price = scanner.next();

        try {
            ps = getConnection().prepareStatement("INSERT INTO books(name, price) VALUES('" + name + "'," + price + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database error");
            return false;
        }
    }

    public static Books getBookById() {
        System.out.print("Enter the id of the book: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM books WHERE id =" + id);
            rs = ps.executeQuery();

            int idB, price;
            String name;

            Books books = new Books();

            while (rs.next()) {
                idB = rs.getInt("id");
                name = rs.getString("name");
                price = rs.getInt("price");
                books.setName(name);
                books.setId(idB);
                books.setPrice(price);
            }
            return books;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean changeBookName() {
        System.out.print("Enter a book name to change: ");
        String name = scanner.next();
        System.out.print("Enter a new name: ");
        String nameNew = scanner.next();

        try {
            ps = getConnection().prepareStatement("UPDATE books SET name='" + nameNew + "'WHERE name='" + name + "'");
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database error");
            return false;
        }
    }

    public static boolean deleteBookByName() {
        System.out.print("Enter the id of the book: ");
        String name = scanner.next();

        try {
            //DELETE FROM books WHERE Name='Upe';
            ps = getConnection().prepareStatement("DELETE FROM books WHERE name ='" + name + "'");
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database error");
            return false;
        }
    }
}
