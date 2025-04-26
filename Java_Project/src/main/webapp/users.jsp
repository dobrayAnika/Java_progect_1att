<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.book.model.User" %>
<html>
<head>
    <title>Пользователи</title>
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
<h2>Пользователи</h2>

<div class="form-container">
    <form action="users" method="post">
        <input type="text" name="name" placeholder="Имя" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="submit" value="Добавить">
    </form>
</div>

<table>
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Email</th>
    </tr>
    <% for (User user : (List<User>)request.getAttribute("users")) { %>
    <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getName() %></td>
        <td><%= user.getEmail() %></td>
    </tr>
    <% } %>
</table>

<a href="index" class="home-button">Вернуться на главную</a>
</body>
</html>