package com.book.db;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseInitializer {

    public static void initializeDatabase() {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            // Создание таблицы пользователей
            String createUsersTable = "CREATE TABLE IF NOT EXISTS Users (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(100) NOT NULL, " +
                    "email VARCHAR(100) UNIQUE NOT NULL" +
                    ");";

            // Создание таблицы прочитанных книг
            String createReadBooksTable = "CREATE TABLE IF NOT EXISTS ReadBooks (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "user_id INT NOT NULL, " +
                    "book_id INT NOT NULL, " +
                    "book_title VARCHAR(255) NOT NULL, " +
                    "FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE" +
                    ");";

            // Создание таблицы всех книг
            String createBooksTable = "CREATE TABLE IF NOT EXISTS Books (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "title VARCHAR(255) NOT NULL" +
                    ");";

// Выполнение SQL-запросов
            statement.executeUpdate(createBooksTable);
            statement.executeUpdate(createUsersTable);
            statement.executeUpdate(createReadBooksTable);

            System.out.println("Таблицы успешно созданы или уже существуют.");
        } catch (SQLException e) {
            System.err.println("Ошибка при создании таблиц: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        initializeDatabase();
    }
}
