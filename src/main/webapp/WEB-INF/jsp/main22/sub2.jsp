<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-06
  Time: 오후 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>공급자 목록</h1>
<table>
  <tr>
    <th>ID</th>
    <th>NAME</th>
    <th>PHONE</th>
  </tr>

  <c:forEach items="${supplierList}" var="list">
    <tr>
      <td>${list.id}</td>
      <td>${list.name}</td>
      <td>${list.phone}</td>
    </tr>
  </c:forEach>
</table>

<div>
  <c:forEach begin="1" end="${lastPageNumber}" var="pageNumber">
    <a href="/main22/sub2?p=${pageNumber}">${pageNumber}</a>
  </c:forEach>
</div>
</body>
</html>
