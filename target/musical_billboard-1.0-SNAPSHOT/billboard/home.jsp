<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My profile</title>
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
    Покупки:
    <p>
        <c:forEach items="${purchases}" var="purchase">
            <a href="/concert?id=${ticket.getById(purchase.getTicketId()).getConcertId()}">Концерт</a>
            Тип билета: ${ticket.getById(purchase.getTicketId()).getCategory()}<br/>
            Стоимость: ${ticket.getById(purchase.getTicketId()).getCost()}<br/>
            Количество: ${purchase.getAmount()}<br/>
        </c:forEach>
    </p>




    
</body>
</html>
<!-- todo количество купленных билетов-->