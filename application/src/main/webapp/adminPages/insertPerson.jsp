<%@ page contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8" language="java"%>

<html>
<head>
<title>Employees</title>
</head>
<body>
<form action="insert" method="post">
    Name:<input name="name" type="text">
    Age:<input name="age" type="text">
    Login:<input name="login" type="text">
    Password:<input name="password" type="password">
    Role:<input name="role" type="text">
    Group:<input name="group" type="text">
    <input type="submit">
</form>

<form action="adminStartPage" method="get">
    Выйти в главное меню:
    <input type="submit">
</form>

<form action="adminStartPage" method="get">
    <input type="submit" value="Главное меню">
</form>



</body>
</html>