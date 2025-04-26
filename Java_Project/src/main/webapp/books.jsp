<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.book.model.Book" %>
<html>
<head>
  <title>Книжный сайт — Все книги</title>
  <style>
    body { font-family: Arial, sans-serif; }
    table { width: 100%; border-collapse: collapse; margin-bottom: 20px; }
    th, td { border: 1px solid black; padding: 8px; text-align: left; }
    th { background-color: #f2f2f2; }
  </style>
</head>
<body>

<h2>Список всех книг</h2>
<table>
  <tr>
    <th>ID книги</th>
    <th>Название книги</th>
  </tr>
  <%
    List<Book> books = (List<Book>) request.getAttribute("books");
    for (Book book : books) {
  %>
  <tr>
    <td><%= book.getId() %></td>
    <td><%= book.getTitle() %></td>
  </tr>
  <% } %>
</table>

</body>
</html>
