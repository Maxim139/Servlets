<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>

<html>
<head>
<title>Employees</title>
</head>
<body>
<form action="" method="get">
    Работать с персоналом:
    <input type="submit">
</form>


<c:forEach var="person" items="${empList}" >
        <p>${person}</p>
    </c:forEach>



</body>
</html>
