package com.book.service;

import com.book.dao.BookReadDAO;
import com.book.model.BookRead;

import java.util.List;

public class BookReadService {
    public void addReadBook(int userId, int bookId, String title) {
        BookReadDAO.addBookRead(userId, bookId, title);
    }

    public List<BookRead> getAllReadBooks() {
        return BookReadDAO.getReadBooks();
    }
}
