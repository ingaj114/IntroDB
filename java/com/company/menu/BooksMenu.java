package com.company.menu;

import com.company.controllers.BooksController;

import java.util.Scanner;

public class BooksMenu {

    public static void menuBooks() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to do?: ");
        System.out.println("1. Add a new book");
        System.out.println("2. Get book by id");
        System.out.println("3. Edit the name of a book");
        System.out.println("4. Delete a book by name");

        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println(BooksController.addBook() ? "Successfully added a new book" : "Book not added");
                break;
            case 2:
                System.out.println(BooksController.getBookById().getName());
                break;
            case 3:
                System.out.println(BooksController.changeBookName() ? "Successfully changed name" : "Name not changed");
                break;
            case 4:
                System.out.println(BooksController.deleteBookByName() ? "Successfully deleted a book" : "Book not deleted");
                break;
            default:
                System.out.println("Invalid option, try again!");
                menuBooks();
        }
    }


}
