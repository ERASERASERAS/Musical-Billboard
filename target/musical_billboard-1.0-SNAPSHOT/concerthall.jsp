<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${concert_hall.getName()}</title>
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
                <a href="/home" >Личный кабинет</a>
                <a href="/login?logout=true">Выход</a>
            </span>
    </c:if>

    <br/>
    Название: ${concert_hall.getName()} <br/>
    Адрес: ${concert_hall.getAddress()} <br/>
    Телефон: ${concert_hall.getTelephone()} <br/>
    E-mail: ${concert_hall.getEmail()} <br/>

</body>
</html>
