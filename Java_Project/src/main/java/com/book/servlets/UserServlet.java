package com.book.servlets;

import com.book.service.UserService;
import com.book.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String search = request.getParameter("search");
        List<User> users;

        if (search != null && !search.isEmpty()) {
            users = userService.findByName(search);
        } else {
            users = userService.getAllUsers();
        }

        request.setAttribute("users", users);
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        if (name != null && email != null) {
            userService.addUser(name, email);
        }

        response.sendRedirect("users");
    }
}
