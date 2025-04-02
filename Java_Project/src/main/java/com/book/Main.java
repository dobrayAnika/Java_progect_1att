package com.book;

import com.book.dao.BookReadDAO;
import com.book.dao.UserDAO;
import com.book.db.DatabaseConnection;

import static com.book.db.DatabaseInitializer.initializeDatabase;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.getConnection();
//        UserDAO.addUser("Маша", "Masha@example.com");
//        UserDAO.addUser("Петя", "petya@example.com");


        BookReadDAO.addBookRead(1, 1, "Красный дракон");

        System.out.println("Users:");
        UserDAO.printUsers();

    }
}
