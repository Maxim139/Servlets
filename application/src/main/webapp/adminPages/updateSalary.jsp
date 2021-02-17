<%@ page contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8" language="java"%>

<html>
<head>
<title>Employees</title>
</head>
<body>
<form action="updateSalary" method="put">
    id: <input name="id" type="text">
    Month: <input name="month" type="text">
    Salary: <input name="salary" type="text">
    <input type="submit">
</form>

<form action="adminStartPage" method="get">
    Выйти в главное меню:
    <input type="submit">
</form>

</body>
</html>