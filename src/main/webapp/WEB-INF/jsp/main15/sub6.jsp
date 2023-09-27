<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-27
  Time: 오전 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--같은 세션을 쓰고 있기 때문에 sub6 method에 set메소드가 없어도 username이 저장되어있다.--%>
<h1>여전히 ${username}님 반갑습니다.</h1>
<a href="/main15/sub4">이름 다시 등록하러 가기</a>
</body>
</html>
