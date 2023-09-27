<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-27
  Time: 오전 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><c:forEach items="${items}" var="item">
    ${item}
</c:forEach> </h1>

<h1><c:forEach items="${sessionScope.items}" var="sitem">
    ${sitem}
</c:forEach> </h1>
</body>
</html>
