<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-22
  Time: 오후 3:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<style>
    table {
        border-collapse: collapse;
        border : 1px solid black;
        width: 100%;
    }
    th {
        background-color: #eee;
    }

    th, td {
        padding : 5px;

    }
</style>

<table>
    <tr>
        <th>id</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>class</th>
        <th>phone</th>
    </tr>

    <c:forEach items="${moving}" var="item" varStatus="status">
        <tr>
        <%--  item. property 를 꺼낸다. --%>
            <td>${item.id}</td>
            <td>${item.firstName}</td>
            <td>${item.lastName}</td>
            <td>${item.className}</td>
            <td>${item.phoneNumber}</td>
        </tr>
    </c:forEach>

</table>



</body>
</html>
