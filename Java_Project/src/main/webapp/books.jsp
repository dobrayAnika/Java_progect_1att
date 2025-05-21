<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.book.model.Book" %>
<html>
<head>
  <title>Книги</title>
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      margin: 0;
      padding: 20px;
      background-color: #f5f5f5;
      color: #333;
    }
    .container {
      max-width: 1200px;
      margin: 0 auto;
      background: white;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    h2 {
      color: #2c3e50;
      margin-top: 0;
      padding-bottom: 10px;
      border-bottom: 2px solid #3498db;
    }
    .form-container {
      background: #f8f9fa;
      padding: 20px;
      border-radius: 5px;
      margin-bottom: 30px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.05);
    }
    .form-row {
      display: flex;
      gap: 15px;
      align-items: flex-end;
    }
    .form-group {
      flex: 1;
    }
    label {
      display: block;
      margin-bottom: 5px;
      font-weight: 600;
      color: #495057;
    }
    input[type="text"] {
      width: 100%;
      padding: 10px;
      border: 1px solid #ced4da;
      border-radius: 4px;
      font-size: 16px;
      background-color: white;
    }
    .btn {
      padding: 10px 20px;
      border: none;
      border-radius: 4px;
      font-size: 16px;
      cursor: pointer;
      transition: all 0.3s;
    }
    .btn-primary {
      background-color: #3498db;
      color: white;
    }
    .btn-primary:hover {
      background-color: #2980b9;
    }
    .btn-danger {
      background-color: #e74c3c;
      color: white;
      border: none;
      padding: 10px 15px;
      border-radius: 4px;
      font-size: 14px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }
    .btn-danger:hover {
      background-color: #c0392b;
    }
    .btn-home {
      background-color: #2ecc71;
      color: white;
      text-decoration: none;
      display: inline-block;
      margin-top: 20px;
      padding: 10px 20px;
      border-radius: 4px;
    }
    .btn-home:hover {
      background-color: #27ae60;
    }
    table {
      width: 100%;
      border-collapse: collapse;
      margin-bottom: 20px;
    }
    th, td {
      padding: 12px 15px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }
    th {
      background-color: #3498db;
      color: white;
      font-weight: 600;
    }
    tr:hover {
      background-color: #f5f5f5;
    }
    .actions {
      white-space: nowrap;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Книги</h2>

  <div class="form-container">
    <form action="books" method="post">
      <div class="form-row">
        <div class="form-group">
          <label for="title">Название книги:</label>
          <input type="text" id="title" name="title" placeholder="Введите название книги" required>
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-primary">Добавить</button>
        </div>
      </div>
    </form>
  </div>

  <table>
    <thead>
    <tr>
      <th>ID</th>
      <th>Название</th>
      <th class="actions">Действия</th>
    </tr>
    </thead>
    <tbody>
    <% for (Book book : (List<Book>)request.getAttribute("books")) { %>
    <tr>
      <td><%= book.getId() %></td>
      <td><%= book.getTitle() %></td>
      <td class="actions">
        <form action="books" method="post" style="display: inline;">
          <input type="hidden" name="deleteId" value="<%= book.getId() %>">
          <button type="submit" class="btn-danger">Удалить</button>
        </form>
      </td>
    </tr>
    <% } %>
    </tbody>
  </table>

  <a href="index" class="btn-home">Вернуться на главную</a>
</div>
</body>
</html>
