<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-26
  Time: 오후 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/main13/sub8">
    <div>
        <label for="input1">아이디</label>
        <input type="number" name="id" id="input1">
    </div>
    <div>
        <label for="input2">이름</label>
        <input type="text" name="name" id="input2">
    </div>
    <div>
        <label for="input3">주소</label>
        <input type="text" name="address" id="input3">
    </div>
    <div>
        <label for="input4">약속시간</label>
        <input type="datetime-local" name="schedule" id="input4">
    </div>
    <h3>할 것들</h3>
    <div>
        <label for="input5">영화</label>
        <input type="checkbox" name="todos" id="input5" value="movie">
    </div>
    <div>
        <label for="input6">쇼핑</label>
        <input type="checkbox" name="todos" id="input6" value="shopping">
    </div>
    <div>
        <label for="input7">식사</label>
        <input type="checkbox" name="todos" id="input7" value="lunch">
    </div>
    <button>제출</button>
</form>
</body>
</html>
