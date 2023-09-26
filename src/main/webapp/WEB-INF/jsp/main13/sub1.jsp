<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-26
  Time: 오전 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>input 요소들</h3>
<form action="/main13/sub2">
<%--    div*10>input[name=param$]^button{전송}--%>
    <div>
        <input type="text" name="param1">
    </div>
    <div>
        <input type="password" name="param2">
    </div>
    <div>
        <input type="date" name="param3">
    </div>
    <div>
        <input type="button" name="param4" value="어떤 버튼">
    </div>
    <div>
        <input type="number" name="param5">
    </div>
    <div>
        <input type="submit" name="param6" value="회원가입">
<%--        submit은 button과 같은 역할--%>
    </div>
    <div>
        <input type="radio" name="param7">
<%--        같은 name attribute를 가진 radio중에서 하나만 선택--%>
    </div>
    <div>
        <input type="radio" name="param7">
    </div>
    <div>
        <input type="checkbox" name="param9">
<%--        여러개 선택가능 name같지 않아도 되지만, 같게하는게 좋다.--%>
    </div>
    <div>
        <input type="checkbox" name="param9">
    </div>
    <div>
        <input type="hidden" name="param10" value="some value">
<%--        사용자에게 보이진 않지만, value를 넘기기위해 사용--%>
    </div>
    <button>전송</button>
</form>
<hr>

<form action="/main13/sub2">
    <div>
        <input type="text" name="param1" value="son">
    </div>
    <div>
        <input type="text" name="param2" placeholder="이름을 입력해주세요.">
    </div>
    <div>
<%--        입력 글자의 길이 제한--%>
        <input type="text" maxlength="5">
    </div>
    <div>
<%--        필수입력란--%>
        <input type="text" required>
    </div>
    <div>
        <input type="text" name="param3" readonly value="son">
    </div>
    <div>
<%--        disabled : param값 전송도 안되고, 수정도 안됨--%>
        <input type="text" name="param4" value="son" disabled>
    </div>
    <div>
<%--        patter : 정규표현식 사용--%>
        <input type="text" pattern="/d{3}" name="param5">
    </div>
    <div>
        <input type="checkbox" name="param6" checked id="">
    </div>
    <div>
        <input type="checkbox" name="param6" id="">
    </div>
    <div>
        <input type="radio" name="param7" id="">
    </div>
    <div>
        <input type="radio" name="param7" checked id="">
    </div>
    <div>
        <input type="file" multiple>
    </div>
    <button>전송</button>
</form>

<hr>

<form action="/main13/sub2">
    <label for="input1">
        주소
    </label>
    <input id="input1" type="text">
    <br>
<%--    div>div*3>labael[for=check$]>lorem1^input:c#check$--%>
    <div>
        <div>
<%--            input 과 label을 같이 쓰는 경향이 있다.--%>
            <labael for="check1">Lorem.</labael>
            <input type="checkbox" name="" id="check1">
        </div>
        <div>
            <labael for="check2">Eum!</labael>
            <input type="checkbox" name="" id="check2">
        </div>
        <div>
            <labael for="check3">Culpa.</labael>
            <input type="checkbox" name="" id="check3">
        </div>
    </div>
<%--    submit 과 button차이 --> submit은 종료X button은 종료O --> button에 이미지등의 컨텐츠를 넣을 수 있다. --%>
    <input type="submit" value="전송">
    <button>전송</button>

</form>
</body>
</html>
