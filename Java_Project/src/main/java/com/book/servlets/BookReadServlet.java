package com.book.servlets;

import com.book.model.BookRead;
import com.book.model.User;
import com.book.service.BookReadService;
import com.book.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class BookReadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService userService = new UserService();
        BookReadService bookService = new BookReadService();

        List<User> users = userService.getAllUsers();
        List<BookRead> books = bookService.getAllReadBooks();

        request.setAttribute("users", users);
        request.setAttribute("books", books);

        request.getRequestDispatcher("book.jsp").forward(request, response);
    }
}
