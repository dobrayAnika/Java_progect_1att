<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.book.model.BookRead" %>
<html>
<head>
  <title>Прочитанные книги</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    table { width: 100%; border-collapse: collapse; margin-bottom: 20px; }
    th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
    th { background-color: #f2f2f2; }
    .home-button {
      display: inline-block;
      padding: 10px 20px;
      background-color: #2196F3;
      color: white;
      text-decoration: none;
      border-radius: 4px;
      margin-top: 20px;
    }
    .home-button:hover {
      background-color: #0b7dda;
    }
  </style>
</head>
<body>
<h2>Прочитанные книги</h2>

<table>
  <tr>
    <th>ID</th>
    <th>ID пользователя</th>
    <th>ID книги</th>
    <th>Название</th>
  </tr>
  <% for (BookRead book : (List<BookRead>)request.getAttribute("books")) { %>
  <tr>
    <td><%= book.getId() %></td>
    <td><%= book.getUserId() %></td>
    <td><%= book.getBookId() %></td>
    <td><%= book.getBookTitle() %></td>
  </tr>
  <% } %>
</table>

<a href="index" class="home-button">Вернуться на главную</a>
</body>
</html>