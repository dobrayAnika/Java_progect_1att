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
        List<Book> allBooks = bookService.getAllBooks();

        String searchUser = request.getParameter("searchUser");
        String searchBook = request.getParameter("searchBook");

        List<BookRead> readBooks = bookReadService.getAllReadBooks();

        // Карты для быстрого доступа к имени пользователя и названию книги
        HashMap<Integer, String> userIdToNameMap = new HashMap<>();
        for (User user : users) {
            userIdToNameMap.put(user.getId(), user.getName());
        }

        HashMap<Integer, String> bookIdToTitleMap = new HashMap<>();
        for (Book book : allBooks) {
            bookIdToTitleMap.put(book.getId(), book.getTitle());
        }

        // Фильтрация по имени пользователя и названию книги
        if ((searchUser != null && !searchUser.isEmpty()) || (searchBook != null && !searchBook.isEmpty())) {
            readBooks.removeIf(record -> {
                String userName = userIdToNameMap.getOrDefault(record.getUserId(), "").toLowerCase();
                String bookTitle = bookIdToTitleMap.getOrDefault(record.getBookId(), "").toLowerCase();
                boolean matchesUser = searchUser == null || searchUser.isEmpty() || userName.contains(searchUser.toLowerCase());
                boolean matchesBook = searchBook == null || searchBook.isEmpty() || bookTitle.contains(searchBook.toLowerCase());
                return !(matchesUser && matchesBook);
            });
        }

        request.setAttribute("users", users);
        request.setAttribute("readBooks", readBooks);
        request.setAttribute("allBooks", allBooks);
        request.setAttribute("userIdToNameMap", userIdToNameMap);
        request.setAttribute("bookIdToTitleMap", bookIdToTitleMap);
        request.setAttribute("searchUser", searchUser != null ? searchUser : "");
        request.setAttribute("searchBook", searchBook != null ? searchBook : "");

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