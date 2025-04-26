package com.book.service;

import com.book.dao.UserDAO;
import com.book.model.User;

import java.util.List;

public class UserService {
    public void addUser(String name, String email) {
        // Здесь можно добавить валидации
        UserDAO.addUser(name, email);
    }

    public List<User> getAllUsers() {
        return UserDAO.getUsers();
    }
}
