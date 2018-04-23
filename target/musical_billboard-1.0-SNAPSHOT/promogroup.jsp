<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${promo_group.getName()}</title>
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
    Название: ${promo_group.getName()} <br/>
    E-mail: ${promo_group.getEmail()} <br/>
    Телефон: ${promo_group.getTelephone()} <br/>



</body>
</html>
