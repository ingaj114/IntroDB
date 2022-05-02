package com.company.objects;
import com.company.dbhelper.DbConnection;
import com.company.login.Auth;
import java.util.Scanner;

import com.company.menu.AuthorsMenu;
import com.company.menu.StudentMenu;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option: ");
        System.out.println("1. Login");
        System.out.println("2. Sign up");
        int option = scanner.nextInt();

        switch (option) {
            case 1: if (Auth.login()) {
                System.out.println("Login successful.");
            } else {
                System.out.println("Invalid login credentials. Try again!");
            }
                break;
            case 2:
                Auth.signUp();
                break;
        }
        //StudentMenu.menu();
        System.out.println();
        AuthorsMenu.menu();

    }
}
