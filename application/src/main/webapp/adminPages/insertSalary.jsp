<%@ page contentType="text/html; UTF-8" language="java"%>

<html>
<head>
<title>
Добавление зарплат
</title>
</head>
<body>
<form action="insertSalary" method="post">
    id:<input name="id" type="text">
    month:<input name="month" type="text">
    salary:<input name="salary" type="text">
    <input type="submit">
</form>

<form action="adminStartPage" method="get">
    Выйти в главное меню:
    <input type="submit">
</form>

</body>
</html>