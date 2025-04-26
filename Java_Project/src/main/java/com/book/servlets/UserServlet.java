package com.book.servlets;

import com.book.dao.UserDAO;
import com.book.executor.DbExecutor;
import com.book.model.User;
import com.book.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    private final UserService userService;

    public UserServlet() {
        DbExecutor dbExecutor = new DbExecutor();
        UserDAO userDAO = new UserDAO(dbExecutor);
        this.userService = new UserService(userDAO);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> users = userService.getAllUsers();

        request.setAttribute("users", users);
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }
}
