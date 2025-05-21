package com.book.dao;

import com.book.executor.DbExecutor;
import com.book.extractor.BookExtractor;
import com.book.model.Book;

import java.util.List;

public class BookDAO {
    private static BookDAO instance;
    private final DbExecutor dbExecutor;

    private BookDAO() {
        this.dbExecutor = DbExecutor.getInstance();
    }

    public static BookDAO getInstance() {
        if (instance == null) {
            instance = new BookDAO();
        }
        return instance;
    }

    public void addBook(String title) {
        String sql = "INSERT INTO Books (title) VALUES (?)";
        dbExecutor.update(sql, title);
        System.out.println("Книга добавлена: " + title);
    }

    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM Books";
        return dbExecutor.query(sql, BookExtractor::extract);
    }

    public void deleteBook(int id) {
        String sql = "DELETE FROM Books WHERE id = ?";
        dbExecutor.update(sql, id);
        System.out.println("Книга удалена, ID: " + id);
    }

    public List<Book> findByTitle(String title) {
        String sql = "SELECT * FROM Books WHERE title LIKE ?";
        return dbExecutor.query(sql, BookExtractor::extract, "%" + title + "%");
    }

}
