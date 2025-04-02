package com.book.dao;

import com.book.db.DatabaseConnection;
import com.book.model.BookRead;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookReadDAO {

    // Добавление записи о прочитанной книге
    public static void addBookRead(int userId, int bookId, String bookTitle) {
        String sql = "INSERT INTO ReadBooks (user_id, book_id, book_title) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, bookId);
            stmt.setString(3, bookTitle);
            stmt.executeUpdate();
            System.out.println("Добавлена прочитанная книга: " + bookTitle);
        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении прочитанной книги: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Получение всех записей о прочитанных книгах
    public static List<BookRead> getReadBooks() {
        List<BookRead> readBooks = new ArrayList<>();
        String sql = "SELECT * FROM ReadBooks";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                BookRead bookRead = new BookRead(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("book_id"),
                        rs.getString("book_title")
                );
                readBooks.add(bookRead);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при получении прочитанных книг: " + e.getMessage());
            e.printStackTrace();
        }
        return readBooks;
    }

    // Вывод всех записей о прочитанных книгах
    public static void printReadBooks() {
        List<BookRead> readBooks = getReadBooks();
        if (readBooks.isEmpty()) {
            System.out.println("В базе нет прочитанных книг.");
        } else {
            readBooks.forEach(book ->
                    System.out.println("ID: " + book.getId() + ", ID пользователя: " + book.getUserId() +
                            ", ID книги: " + book.getBookId() + ", Название: " + book.getBookTitle())
            );
        }
    }
}
