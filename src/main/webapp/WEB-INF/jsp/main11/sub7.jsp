<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-25
  Time: 오후 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- /main11/sub7?show=true --%>
<%-- table 형식의 데이터 출력--%>
<c:if test="${param.show == true}">

    <table>
        <tr>
            <th>id</th>
            <th>firstName</th>
            <th>lastName</th>
            <th>class</th>
            <th>phone</th>
        </tr>
        <tr>
            <c:forEach items="${moving}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.firstName}</td>
            <td>${item.lastName}</td>
            <td>${item.className}</td>
            <td>${item.phoneNumber}</td>
        </tr>
        </c:forEach>
        </tr>
    </table>

</c:if>
<c:if test="${param.show != true}">
    <p>데이터가 없습니다.</p>
</c:if>
<%-- /main/sub7 --%>
<%-- 데이터가 없습니다.--%>

<%-- 강사님 방법 moving없으면 데이터 없음 --%>
<c:if test="${empty moving}">
    <p> 데이터 없음 </p>
</c:if>
<c:if test="${not empty moving}">
    <p>출력</p>
</c:if>

<%-- choose태그를 사용해서 하는 방법--%>
<h1>choose 태그 사용</h1>
<c:choose>
    <c:when test="${not empty moving}">
        <table>
            <tr>
                <th>ID</th>
                <th>FIRST NAME</th>
                <th>LAST NAME</th>
                <th>CLASS</th>
                <th>PHONE</th>
            </tr>
            <c:forEach items="${moving}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.firstName}</td>
                    <td>${item.lastName}</td>
                    <td>${item.className}</td>
                    <td>${item.phoneNumber}</td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <h1>데이터가 없습니다.</h1>
    </c:otherwise>
</c:choose>

</body>
</html>
