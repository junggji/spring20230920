<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-22
  Time: 오후 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${personMap.person1.lastName}</h1>
<h1>${personMap["person1"].lastName}</h1>
<h1>${personMap.person2.lastName}</h1>

<hr>

<h1>${people["1st"].lastName}</h1>
<h1>${people["2st"].lastName}</h1>

</body>
</html>
