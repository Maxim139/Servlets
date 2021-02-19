<%@ page contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8" language="java"%>

<html>
<head>
<title>Employees</title>
</head>
<body>
<%= session.getAttribute("salary") %>

<form action="teacherStartPage" method="get">
    Выйти в главное меню:
    <input type="submit">
</form>

</body>
</html>