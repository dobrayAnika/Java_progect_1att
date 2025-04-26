package com.book.dao;

import com.book.executor.DbExecutor;
import com.book.extractor.UserExtractor;
import com.book.model.User;

import java.util.List;

public class UserDAO {
    private final DbExecutor dbExecutor;

    public UserDAO(DbExecutor dbExecutor) {
        this.dbExecutor = dbExecutor;
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
