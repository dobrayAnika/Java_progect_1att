<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Книжный сайт</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
            background-color: #f5f5f5;
        }
        .welcome {
            font-size: 36px;
            margin-bottom: 40px;
            color: #333;
        }
        .button-container {
            display: flex;
            gap: 20px;
            margin-bottom: 30px;
        }
        .nav-button {
            padding: 12px 24px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s;
        }
        .nav-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="welcome">Добро пожаловать!</div>

<div class="button-container">
    <a href="users" class="nav-button">Пользователи</a>
    <a href="books" class="nav-button">Книги</a>
    <a href="read_books" class="nav-button">Прочитанные книги</a>
</div>
</body>
</html>