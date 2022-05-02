package com.company.controllers;

import com.company.objects.Authors;
import com.company.objects.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import static com.company.dbhelper.DbConnection.getConnection;

public class AuthorsController {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void addAuthor() {
        System.out.print("Enter author's book id: ");
        int id = scanner.nextInt();
        System.out.print("Enter author's name: ");
        String name = scanner.next();
        System.out.print("Enter author's age: ");
        int age = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("INSERT INTO authors(bookid, name, age) VALUES(" + id + ",'" + name + "'," + age +")");
            ps.execute();
            System.out.println("Added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Authors getAuthorsById() {
        System.out.print("Enter the id: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM authors WHERE id =" + id);
            rs = ps.executeQuery();

            int authorId, bookId, age;
            String name;

            Authors authors = new Authors();

            while (rs.next()) {
                authorId = rs.getInt("id");
                bookId = rs.getInt("bookid");
                name = rs.getString("name");
                age = rs.getInt("age");
                authors.setId(authorId);
                authors.setBookId(bookId);
                authors.setName(name);
                authors.setAge(age);
            }
            return authors;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void deleteAuthor() {
        System.out.print("Delete author by id: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("DELETE FROM authors WHERE id =" + id);
            ps.execute();
            System.out.println("Deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
