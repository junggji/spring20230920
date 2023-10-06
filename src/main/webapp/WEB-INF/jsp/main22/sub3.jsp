<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-06
  Time: 오전 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .active {
            background-color: yellow;
        }
    </style>
</head>
<body>
<h1>고객목록</h1>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
    </tr>
    <c:forEach items="${customerList}" var="custom">
        <tr>
            <td>${custom.id}</td>
            <td>${custom.name}</td>
        </tr>
    </c:forEach>
</table>
<div>
    <a href="/main22/sub3?p=1">맨앞</a>
    <c:if test="${prevPageNumber > 0}">
    <a href="/main22/sub3?p=${prevPageNumber}">이전</a>
    </c:if>
    <c:forEach begin="${leftPageNumber}" end="${rightPageNumber}" var="page">
        <a
                <c:if test="${page == currentPage}">
                        class="active"
                        </c:if>

                href="/main22/sub3?p=${page}">${page}</a>
    </c:forEach>
    <c:if test="${lastPageNumber >= nextPageNumber}">
    <a href="/main22/sub3?p=${nextPageNumber}">다음</a>
    </c:if>
    <a href="/main22/sub3?p=${lastPageNumber}">맨뒤</a>
</div>
</body>
</html>
