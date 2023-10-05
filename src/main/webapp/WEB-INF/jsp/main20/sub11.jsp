<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-05
  Time: 오후 5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>리스트</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Country</th>
    </tr>

    <c:forEach items="${listlist}" var="list">
        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.country}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
