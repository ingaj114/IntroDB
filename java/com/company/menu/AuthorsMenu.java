package com.company.menu;

import com.company.controllers.StudentController;
import com.company.controllers.AuthorsController;

import java.util.Scanner;

public class AuthorsMenu {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add an author.");
        System.out.println("2. Get an author by id.");
        System.out.println("3. Delete an author by id.");

        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                AuthorsController.addAuthor();
                break;
            case 2:
                System.out.println(AuthorsController.getAuthorsById().getName());
                break;
            case 3:
                AuthorsController.deleteAuthor();
                break;
            default:
                System.out.println("Invalid option, try again!");
                menu();
        }
    }


}
