package com.company.menu;

import com.company.controllers.StudentController;

import java.util.Scanner;

public class StudentMenu {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to do?: ");
        System.out.println("1. Add a student");
        System.out.println("2. Get student");
        System.out.println("3. Add score");
        System.out.println("4. Delete score");
        System.out.println("5. Edit score");
        System.out.println("6. Delete score and student");


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
               StudentController.deleteScore();
                break;
            case 5:
                StudentController.editScore();
                break;
            case 6:
                StudentController.deleteScore();
                StudentController.deleteScore(1);
                break;
            default:
                System.out.println("Invalid option, try again!");
                menu();
        }
    }


}
