package com.book.servlets;

import com.book.dao.BookReadDAO;
import com.book.model.BookRead;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.book.dao.UserDAO;
import com.book.model.User;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = UserDAO.getUsers();

        request.setAttribute("users", users);

        request.getRequestDispatcher("users.jsp").forward(request, response);
    }
}