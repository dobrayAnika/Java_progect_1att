package com.book.service;

import com.book.dao.BookReadDAO;
import com.book.model.BookRead;

import java.util.List;

public class BookReadService {
    private static BookReadService instance;
    private final BookReadDAO bookReadDAO;

    private BookReadService() {
        this.bookReadDAO = BookReadDAO.getInstance();
    }

    public static BookReadService getInstance() {
        if (instance == null) {
            instance = new BookReadService();
        }
        return instance;
    }

    public void addReadBook(int userId, int bookId, String title) {
        bookReadDAO.addBookRead(userId, bookId, title);
    }

    public List<BookRead> getAllReadBooks() {
        return bookReadDAO.getReadBooks();
    }
}
