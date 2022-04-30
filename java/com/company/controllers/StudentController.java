package com.company.controllers;

import com.company.objects.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import static com.company.dbhelper.DbConnection.getConnection;

public class StudentController {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addStudent() {

        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the age: ");
        int age = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("INSERT INTO students(name, age) VALUES('" + name + "'," + age + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database error");
            return false;
        }
    }

    public static Student getStudentById() {
        System.out.print("Enter the id: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM students WHERE id =" + id);
            rs = ps.executeQuery();

            int studentId, age;
            String name;

            Student student = new Student();

            while (rs.next()) {
                studentId = rs.getInt("id");
                name = rs.getString("name");
                age = rs.getInt("age");
                student.setName(name);
                student.setId(studentId);
                student.setAge(age);
            }
            return student;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static boolean addStudentScores() {
        System.out.print("Enter the id: ");
        int id = scanner.nextInt();
        System.out.print("Enter the score in mathematics: ");
        int math = scanner.nextInt();
        System.out.print("Enter the score in english: ");
        int eng = scanner.nextInt();
        System.out.print("Enter the score in physics: ");
        int phys = scanner.nextInt();
        System.out.print("Enter the score in chemistry: ");
        int chem = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("INSERT INTO scores(studentid, mathematics, english, physics, chemistry) " +
                    "VALUES(" + id + "," + math + "," + eng + "," + phys + "," + chem + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database error");
            return false;
        }
    }

    public static void editScore() {
        System.out.print("Enter the id to change: ");
        int id = scanner.nextInt();
        System.out.print("Enter a subject to change: ");
        String subject = scanner.next();
        System.out.print("Enter a score: ");
        int score = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("UPDATE scores SET " + subject + " = " + score + "WHERE id=" + id);
            ps.execute();
            System.out.println("Changed successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void editStudent() {
        System.out.print("Enter the id to change: ");
        int id = scanner.nextInt();
        System.out.print("What field would you like to edit (name/age): ");
        String fieldToEdit = scanner.next();
        System.out.print("Enter a value you want to edit to: ");
        String value = scanner.next();

        try {
            ps = getConnection().prepareStatement("UPDATE students SET " + fieldToEdit + " = '" + value + "' WHERE id=" + id);
            ps.execute();
            System.out.println("Changed successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add an overloaded deleteScore() method that takes id(int) as a parameter to allow you to
    // delete a student’s score when a student is deleted from the database.
    public static void deleteScore() {
        System.out.print("Delete score id: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("DELETE FROM scores WHERE id =" + id);
            ps.execute();
            deleteScore(id);
            System.out.println("Student deleted successfully");
        } catch (SQLException e) {
            System.out.println("Database error");
        }
    }

    public static void deleteScore(int id) {
        try {
            ps = getConnection().prepareStatement("DELETE FROM students WHERE id =" + id);
            ps.execute();
            System.out.println("Score deleted successfully");
        } catch (SQLException e) {
            System.out.println("Database error");
        }
    }

}
