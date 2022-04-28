package com.company.objects;

import com.company.dbhelper.DbConnection;
import com.company.menu.BooksMenu;
import com.company.menu.StudentMenu;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //DbConnection.getConnection();
        StudentMenu.menu();
        //BooksMenu.menuBooks();
    }
/*    //TASK
    //Create a BOOKControl and also Create a Book Menu
    //using a template shown and we'll demo them
        public static List<String> filterLessThanFive(List<Books> books) {
            List<String> bookNames = new ArrayList<>();
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getPrice() < 5) books.remove(books.get(i));
            }
            books.forEach(book -> bookNames.add(book.getName()));

            return bookNames;
    }*/
}
