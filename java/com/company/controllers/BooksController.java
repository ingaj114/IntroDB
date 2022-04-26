package com.company.controllers;

import com.company.objects.Books;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import static com.company.dbhelper.DbConnection.getConnection;

public class BooksController {

    private static Scanner scanner = new Scanner((System.in));
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
        int idBook = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM books WHERE id =" + idBook);
            rs = ps.executeQuery();

            int bookId, price;
            String name;

            Books books = new Books();

            while (rs.next()) {
                bookId = rs.getInt("id");
                name = rs.getString("name");
                price = rs.getInt("price");
                books.setName(name);
                books.setId(bookId);
                books.setPrice(price);
            }
            return books;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
