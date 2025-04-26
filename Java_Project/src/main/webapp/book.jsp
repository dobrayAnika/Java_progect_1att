<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.book.model.BookRead" %>
<%@ page import="com.book.model.User" %>
<%@ page import="com.book.model.Book" %>
<html>
<head>
  <title>Прочитанные книги</title>
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
    .form-title {
      margin-top: 0;
      color: #3498db;
    }
    .form-row {
      display: flex;
      gap: 15px;
      margin-bottom: 15px;
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
    select {
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
    .no-records {
      text-align: center;
      padding: 20px;
      color: #7f8c8d;
      font-style: italic;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Прочитанные книги</h2>

  <div class="form-container">
    <h3 class="form-title">Добавить новую запись</h3>
    <form action="read_books" method="post">
      <div class="form-row">
        <div class="form-group">
          <label for="userId">Пользователь:</label>
          <select id="userId" name="userId" required>
            <option value="">-- Выберите пользователя --</option>
            <% for (User user : (List<User>)request.getAttribute("users")) { %>
            <option value="<%= user.getId() %>">
              <%= user.getName() %> (ID: <%= user.getId() %>)
            </option>
            <% } %>
          </select>
        </div>

        <div class="form-group">
          <label for="bookId">Книга:</label>
          <select id="bookId" name="bookId" required>
            <option value="">-- Выберите книгу --</option>
            <% for (Book book : (List<Book>)request.getAttribute("allBooks")) { %>
            <option value="<%= book.getId() %>">
              <%= book.getTitle() %> (ID: <%= book.getId() %>)
            </option>
            <% } %>
          </select>
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
      <th>ID записи</th>
      <th>Пользователь</th>
      <th>Книга</th>
      <th class="actions">Действия</th>
    </tr>
    </thead>
    <tbody>
    <%
      Map<Integer, String> userIdToNameMap = (Map<Integer, String>)request.getAttribute("userIdToNameMap");
      Map<Integer, String> bookIdToTitleMap = (Map<Integer, String>)request.getAttribute("bookIdToTitleMap");
      List<BookRead> readBooks = (List<BookRead>)request.getAttribute("readBooks");

      if (readBooks.isEmpty()) {
    %>
    <tr>
      <td colspan="4" class="no-records">Нет записей о прочитанных книгах</td>
    </tr>
    <%
    } else {
      for (BookRead record : readBooks) {
        String userName = userIdToNameMap.getOrDefault(record.getUserId(), "Неизвестный пользователь");
        String bookTitle = bookIdToTitleMap.getOrDefault(record.getBookId(), "Неизвестная книга");
    %>
    <tr>
      <td><%= record.getId() %></td>
      <td><%= userName %></td>
      <td><%= bookTitle %></td>
      <td class="actions">
        <form action="read_books" method="post" style="display: inline;">
          <input type="hidden" name="deleteId" value="<%= record.getId() %>">
          <button type="submit" class="btn btn-danger">Удалить</button>
        </form>
      </td>
    </tr>
    <%
        }
      }
    %>
    </tbody>
  </table>

  <a href="index" class="btn btn-home">Вернуться на главную</a>
</div>
</body>
</html>