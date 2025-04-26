package com.book.dao;

import com.book.executor.DbExecutor;
import com.book.extractor.BookReadExtractor;
import com.book.model.BookRead;

import java.util.List;

public class BookReadDAO {
    private static BookReadDAO instance;
    private final DbExecutor dbExecutor;

    private BookReadDAO() {
        this.dbExecutor = DbExecutor.getInstance();
    }

    public static BookReadDAO getInstance() {
        if (instance == null) {
            instance = new BookReadDAO();
        }
        return instance;
    }

    public void addBookRead(int userId, int bookId, String bookTitle) {
        String sql = "INSERT INTO ReadBooks (user_id, book_id, book_title) VALUES (?, ?, ?)";
        dbExecutor.update(sql, userId, bookId, bookTitle);
        System.out.println("Добавлена прочитанная книга: " + bookTitle);
    }

    public List<BookRead> getReadBooks() {
        String sql = "SELECT * FROM ReadBooks";
        return dbExecutor.query(sql, BookReadExtractor::extract);
    }
}
