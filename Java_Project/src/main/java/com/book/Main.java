package com.book;

import com.book.dao.BookReadDAO;
import com.book.dao.UserDAO;
import com.book.executor.DbExecutor;
import com.book.model.User;
import com.book.service.BookReadService;
import com.book.service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = UserService.getInstance();
        BookReadService bookReadService = BookReadService.getInstance();

        //userService.addUser("Маша", "masha@example.com");
        //userService.addUser("Петя", "petya@example.com");

        bookReadService.addReadBook(2, 2, "Синий дракон");

        System.out.println("Users:");
        for (User user : userService.getAllUsers()) {
            System.out.println("ID: " + user.getId() + ", Name: " + user.getName() + ", Email: " + user.getEmail());
        }
    }
}
