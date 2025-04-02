package com.book.model;

public class BookRead {
    private int id;
    private int userId;
    private int bookId;
    private String bookTitle;

    public BookRead(int id, int userId, int bookId, String bookTitle) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }
}
