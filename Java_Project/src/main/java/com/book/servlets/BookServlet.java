package com.book.servlets;

import com.book.service.BookService;
import com.book.model.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class BookServlet extends HttpServlet {
    private final BookService bookService = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Book> books = bookService.getAllBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("books.jsp").forward(request, response);
    }

    // BookServlet.java
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Обработка добавления книги
        String title = request.getParameter("title");
        if (title != null && !title.isEmpty()) {
            bookService.addBook(title);
        }

        // Обработка удаления книги
        String deleteId = request.getParameter("deleteId");
        if (deleteId != null && !deleteId.isEmpty()) {
            try {
                int id = Integer.parseInt(deleteId);
                bookService.deleteBook(id);
            } catch (NumberFormatException e) {
                System.err.println("Неверный ID для удаления: " + deleteId);
            }
        }

        response.sendRedirect("books");
    }
}
