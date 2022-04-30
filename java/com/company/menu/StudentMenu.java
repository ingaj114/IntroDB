package com.company.menu;

import com.company.controllers.StudentController;
import com.company.controllers.AuthorsController;

import java.util.Scanner;

public class StudentMenu {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?: ");
        System.out.println("1. Add a student");
        System.out.println("2. Get a student by id");
        System.out.println("3. Add a student score");
        System.out.println("4. Edit a student");
        System.out.println("5. Edit a score");
        System.out.println("6. Delete a scores & student");
        System.out.println();
        System.out.println("7. Add an author");
        System.out.println("8. Get an author by id");
        System.out.println("9. Delete an author by id");

        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println(StudentController.addStudent() ? "Student successfully added" : "Student not added");
                break;
            case 2:
                System.out.println(StudentController.getStudentById().getName());
                break;
            case 3:
                System.out.println(StudentController.addStudentScores() ? "Scores successfully added" : "Scores not added");
                break;
            case 4:
                StudentController.editStudent();
                break;
            case 5:
                StudentController.editScore();
                break;
            case 6:
                StudentController.deleteScore();
                break;
            case 7:
                AuthorsController.addAuthor();
                break;
            case 8:
                System.out.println(AuthorsController.getAuthorById().getName());
                break;
            case 9:
                AuthorsController.deleteAuthor();
                break;
            default:
                System.out.println("Invalid option, try again!");
                menu();
        }
    }


}
