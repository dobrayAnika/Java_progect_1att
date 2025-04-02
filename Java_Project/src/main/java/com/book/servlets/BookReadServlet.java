package com.book.servlets;

import com.book.dao.UserDAO;
import com.book.dao.BookReadDAO;
import com.book.model.BookRead;
import com.book.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class BookReadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = UserDAO.getUsers();
        List<BookRead> books = BookReadDAO.getReadBooks();

        request.setAttribute("users", users);
        request.setAttribute("books", books);

        request.getRequestDispatcher("book.jsp").forward(request, response);
    }
}