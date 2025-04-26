package com.book.service;

import com.book.dao.UserDAO;
import com.book.model.User;

import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addUser(String name, String email) {
        userDAO.addUser(name, email);
    }

    public List<User> getAllUsers() {
        return userDAO.getUsers();
    }
}
