package com.company.menu;

import com.company.controllers.BooksController;

import java.util.Scanner;

public class BooksMenu {

    public static void bookMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to do?: ");
        System.out.println("1. Add a new book");
        System.out.println("2. Get book by id");

        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println(BooksController.addBook() ? "Successfully added a new book" : "Book no added");
                break;
            case 2:
                System.out.println(BooksController.getBookById().getName());
                break;
            default:
                System.out.println("Invalid option, try again!");
                bookMenu();
        }
    }


}
