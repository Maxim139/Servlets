<%@ page contentType="text/html; UTF-8" language="java"%>

<html>
<head>
<title>
Добавление предметов
</title>
</head>
<body>
<form action="insertSubjAndMarks" method="post">
    id:<input name="id" type="text">
    subject:<input name="subject" type="text">
    mark:<input name="mark" type="text">
    <input type="submit">
</form>

<form action="adminStartPage" method="get">
    Выйти в главное меню:
    <input type="submit">
</form>

</body>
</html>