<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.book.model.User" %>
<html>
<head>
    <title>Пользователи</title>
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
        input[type="text"],
        input[type="email"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ced4da;
            border-radius: 4px;
            font-size: 16px;
            background-color: white;
            margin-bottom: 10px;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #3498db;
            border: none;
            border-radius: 4px;
            color: white;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #2980b9;
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
    </style>
</head>
<body>
<div class="container">
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

    <a href="index" class="btn-home">Вернуться на главную</a>
</div>
</body>
</html>
