<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-27
  Time: 오전 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><c:forEach var="food" items="${foods}">
    <p>${food}</p>
</c:forEach>  </h1>
<p>${foods[0]}</p>
<a href="/main15/sub9">sub9</a>
</body>
</html>
