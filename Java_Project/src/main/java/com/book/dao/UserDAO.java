package com.book.dao;

import com.book.executor.DbExecutor;
import com.book.extractor.UserExtractor;
import com.book.model.User;

import java.util.List;

public class UserDAO {
    private static UserDAO instance;
    private final DbExecutor dbExecutor;

    private UserDAO() {
        this.dbExecutor = DbExecutor.getInstance();
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    public void addUser(String name, String email) {
        String sql = "INSERT INTO Users (name, email) VALUES (?, ?)";
        dbExecutor.update(sql, name, email);
        System.out.println("Пользователь добавлен: " + name);
    }

    public List<User> getUsers() {
        String sql = "SELECT * FROM Users";
        return dbExecutor.query(sql, UserExtractor::extract);
    }
}
