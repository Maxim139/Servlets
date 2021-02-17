<%@ page contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8" language="java"%>

<html>
<head>
<title>Employees</title>
</head>
<body>
<form action="updatePerson" method="put">
    id:<input name="id" type="text">
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

</body>
</html>