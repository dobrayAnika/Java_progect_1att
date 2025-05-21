package com.book.service;

import com.book.dao.UserDAO;
import com.book.model.User;

import java.util.List;

public class UserService {
    private static UserService instance;
    private final UserDAO userDAO;

    private UserService() {
        this.userDAO = UserDAO.getInstance();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public void addUser(String name, String email) {
        userDAO.addUser(name, email);
    }

    public List<User> getAllUsers() {
        return userDAO.getUsers();
    }

    public List<User> findByName(String name) {
        return userDAO.findByName(name);
    }

}
