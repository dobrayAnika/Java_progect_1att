<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.book.model.User" %>
<%@ page import="com.book.model.BookRead" %>
<%@ page import="java.awt.print.Book" %>
<html>
<head>
  <title>Книжный сайт</title>
  <style>
    body { font-family: Arial, sans-serif; }
    table { width: 100%; border-collapse: collapse; margin-bottom: 20px; }
    th, td { border: 1px solid black; padding: 8px; text-align: left; }
    th { background-color: #f2f2f2; }
  </style>
</head>
<body>


<h2>Список прочитанных книг</h2>
<table>
  <tr>
    <th>ID</th>
    <th>Id пользователя</th>
    <th>Id книги</th>
    <th>Название</th>
  </tr>
  <%
    List<BookRead> bookReads = (List<BookRead>) request.getAttribute("books");
    for (BookRead book : bookReads) {
  %>
  <tr>
    <td><%= book.getId() %></td>
    <td><%= book.getUserId() %></td>
    <td><%= book.getBookId() %></td>
    <td><%= book.getBookTitle() %></td>
  </tr>
  <% } %>
</table>
</body>
</html>