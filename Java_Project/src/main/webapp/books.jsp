<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.book.model.Book" %>
<html>
<head>
  <title>Книги</title>
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
    .form-container {
      margin-bottom: 20px;
    }
  </style>
</head>
<body>
<h2>Книги</h2>

<div class="form-container">
  <form action="books" method="post">
    <input type="text" name="title" placeholder="Название книги" required>
    <input type="submit" value="Добавить">
  </form>
</div>

<table>
  <tr>
    <th>ID</th>
    <th>Название</th>
    <th>Действия</th>
  </tr>
  <% for (Book book : (List<Book>)request.getAttribute("books")) { %>
  <tr>
    <td><%= book.getId() %></td>
    <td><%= book.getTitle() %></td>
    <td>
      <form action="books" method="post" style="display: inline;">
        <input type="hidden" name="deleteId" value="<%= book.getId() %>">
        <input type="submit" value="Удалить" style="color: red; border: none; background: none; cursor: pointer;">
      </form>
    </td>
  </tr>
  <% } %>
</table>

<a href="index" class="home-button">Вернуться на главную</a>
</body>
</html>