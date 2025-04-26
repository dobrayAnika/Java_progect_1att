package com.book.service;

import com.book.dao.BookReadDAO;
import com.book.model.BookRead;

import java.util.List;

public class BookReadService {
    private final BookReadDAO bookReadDAO;

    public BookReadService(BookReadDAO bookReadDAO) {
        this.bookReadDAO = bookReadDAO;
    }

    public void addReadBook(int userId, int bookId, String title) {
        bookReadDAO.addBookRead(userId, bookId, title);
    }

    public List<BookRead> getAllReadBooks() {
        return bookReadDAO.getReadBooks();
    }
}
