<%@ page contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8" language="java"%>

<!-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->

<html>
<head>
<title>Employees</title>
</head>
<body>

<!--

<table>
<c:forEach items="${marks}" var="${mark}">
  <tr>
    <td><c: value="${mark.getMark()}"></td>
    <td><c: value="${mark.getSubject()}"></td>
  </tr>
  </c:forEach>
</table>
-->

<%= session.getAttribute("marks") %>

<form action="sessionInvalidate" method="get">
    <input type="submit" value="Выйти из аккаунта">
</form>


</body>
</html>
