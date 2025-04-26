package com.book.service;

import com.book.dao.BookDAO;
import com.book.model.Book;

import java.util.List;

public class BookService {
    private static BookService instance;
    private final BookDAO bookDAO;

    private BookService() {
        this.bookDAO = BookDAO.getInstance();
    }

    public static BookService getInstance() {
        if (instance == null) {
            instance = new BookService();
        }
        return instance;
    }

    public void addBook(String title) {
        bookDAO.addBook(title);
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }
}
