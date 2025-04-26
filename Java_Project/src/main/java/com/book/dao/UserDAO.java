package com.book.dao;

import com.book.executor.DbExecutor;
import com.book.extractor.UserExtractor;
import com.book.model.User;

import java.util.List;

public class UserDAO {

    public static void addUser(String name, String email) {
        String sql = "INSERT INTO Users (name, email) VALUES (?, ?)";
        DbExecutor.update(sql, name, email);
        System.out.println("Пользователь добавлен: " + name);
    }

    public static List<User> getUsers() {
        String sql = "SELECT * FROM Users";
        return DbExecutor.query(sql, UserExtractor::extract);
    }

    public static void printUsers() {
        List<User> users = getUsers();
        if (users.isEmpty()) {
            System.out.println("В базе нет пользователей.");
        } else {
            users.forEach(user ->
                    System.out.println("ID: " + user.getId() +
                            ", Name: " + user.getName() +
                            ", Email: " + user.getEmail()));
        }
    }

}
