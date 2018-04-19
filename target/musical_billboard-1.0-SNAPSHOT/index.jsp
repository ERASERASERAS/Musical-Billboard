<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INDEX</title>
</head>
<body>
    <c:if test="${user == null}">
        <span class="top-span">
            <a class="top-span-login-link" href="/login">Войти</a>
            <a class="top-span-login-link" href="/login">Регистрация</a>
        </span>
    </c:if>

    <c:if test="${user != null}">
        <span>
            <a href="/login/?logout=true">Выход</a>
        </span>
    </c:if>

    
        <c:forEach items="${concerts}" var="concert">

        </c:forEach>











</body>
</html>