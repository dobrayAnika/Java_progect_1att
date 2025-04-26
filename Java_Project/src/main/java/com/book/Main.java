package com.book;

import com.book.model.User;
import com.book.model.Book;
import com.book.service.BookReadService;
import com.book.service.BookService;
import com.book.service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = UserService.getInstance();
        BookReadService bookReadService = BookReadService.getInstance();
        BookService bookService = BookService.getInstance();

        //userService.addUser("Маша", "masha@example.com");
        //userService.addUser("Петя", "petya@example.com");

        //bookReadService.addReadBook(2, 2, "Синий дракон");

        // Добавляем книги
        bookService.addBook("Война и мир");
        bookService.addBook("Преступление и наказание");

        // Выводим пользователей
        System.out.println("Users:");
        for (User user : userService.getAllUsers()) {
            System.out.println("ID: " + user.getId() + ", Name: " + user.getName() + ", Email: " + user.getEmail());
        }

        // Выводим книги
        System.out.println("\nBooks:");
        for (Book book : bookService.getAllBooks()) {
            System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle());
        }
    }
}
