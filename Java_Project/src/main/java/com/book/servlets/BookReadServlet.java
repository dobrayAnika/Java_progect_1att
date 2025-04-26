package com.book.servlets;

import com.book.model.BookRead;
import com.book.model.User;
import com.book.model.Book;
import com.book.service.BookReadService;
import com.book.service.UserService;
import com.book.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.HashMap;

public class BookReadServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    private final BookReadService bookReadService = BookReadService.getInstance();
    private final BookService bookService = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> users = userService.getAllUsers();
        List<BookRead> readBooks = bookReadService.getAllReadBooks();
        List<Book> allBooks = bookService.getAllBooks();

        HashMap<Integer, String> userIdToNameMap = new HashMap<>();
        for (User user : users) {
            userIdToNameMap.put(user.getId(), user.getName());
        }

        HashMap<Integer, String> bookIdToTitleMap = new HashMap<>();
        for (Book book : allBooks) {
            bookIdToTitleMap.put(book.getId(), book.getTitle());
        }

        request.setAttribute("users", users);
        request.setAttribute("readBooks", readBooks);
        request.setAttribute("allBooks", allBooks);
        request.setAttribute("userIdToNameMap", userIdToNameMap);
        request.setAttribute("bookIdToTitleMap", bookIdToTitleMap);

        request.getRequestDispatcher("book.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Обработка добавления новой записи
        if (request.getParameter("userId") != null) {
            try {
                int userId = Integer.parseInt(request.getParameter("userId"));
                int bookId = Integer.parseInt(request.getParameter("bookId"));

                String bookTitle = bookService.getAllBooks().stream()
                        .filter(b -> b.getId() == bookId)
                        .findFirst()
                        .map(Book::getTitle)
                        .orElse("Неизвестная книга");

                bookReadService.addBookRead(userId, bookId, bookTitle);
            } catch (NumberFormatException e) {
                System.err.println("Ошибка при обработке параметров: " + e.getMessage());
            }
        }

        // Обработка удаления записи
        if (request.getParameter("deleteId") != null) {
            try {
                int deleteId = Integer.parseInt(request.getParameter("deleteId"));
                bookReadService.deleteBookRead(deleteId);
            } catch (NumberFormatException e) {
                System.err.println("Неверный ID для удаления: " + e.getMessage());
            }
        }

        response.sendRedirect("read_books");
    }
}