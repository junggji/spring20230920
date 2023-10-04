<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-04
  Time: 오후 3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
<c:forEach items="${customers}" var="item">
    <tr>
        <td>${item.id}</td>
        <td>${item.name}</td>
        <td>${item.city}</td>
        <td>${item.country}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
