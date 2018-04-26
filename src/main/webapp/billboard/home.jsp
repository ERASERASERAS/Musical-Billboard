<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My profile</title>
    <link rel="stylesheet" type="text/css" href="https://www.w3schools.com/w3css/4/w3.css">
    <style> a { text-decoration: none } </style>
</head>
<body class="w3-light-blue">
    <c:if test="${user == null}">
        <div class="w3-bar w3-indigo">
            <a class="w3-bar-item w3-button w3-aqua w3-hover-cyan w3-right w3-margin w3-round" href="/login">Войти</a>
            <a class="w3-bar-item w3-button w3-aqua w3-hover-cyan w3-right w3-margin-top w3-round" href="/login">Регистрация</a>
        </div>
    </c:if>
    <c:if test="${user != null}">
        <div class="w3-bar w3-indigo">
            <a class="w3-bar-item w3-button w3-aqua w3-hover-cyan w3-right w3-margin w3-round" href="/billboard/home">Личный кабинет</a>
            <a class="w3-bar-item w3-button w3-aqua w3-hover-cyan w3-right w3-margin-top w3-round" href="/login?logout=true">Выйти</a>
        </div>
    </c:if>
    <div class="w3-bar w3-green">
        <a class="w3-bar-item w3-button w3-hover-lime" href="/">Концерты</a>
        <a class="w3-bar-item w3-button w3-hover-lime" href="/promo">Промо-группы</a>
        <a class="w3-bar-item w3-button w3-hover-lime" href="/concerthall">Залы</a>
    </div>
    <br/>
    <div class="w3-container w3-large w3-margin-bottom">
        Покупки:
    </div>
    <br>
    <div class="w3-container">
        <c:forEach items="${purchases}" var="purchase">
            <a class="w3-btn w3-round w3-yellow w3-hover-orange w3-hover-text-white w3-margin-bottom" href="/concert?id=${ticket.getById(purchase.getTicketId()).getConcertId()}">Ссылка на концерт</a><br>
            <div class="w3-margin-bottom">Тип билета: <span class="w3-badge w3-red">${ticket.getById(purchase.getTicketId()).getCategory()}</span></div> <br/>
            <div class="w3-margin-bottom">Стоимость: <span class="w3-badge w3-teal">${ticket.getById(purchase.getTicketId()).getCost()}</span></div> <br>
            <div class="w3-margin-bottom"> Количество: ${purchase.getAmount()}</div><br/>
        </c:forEach>
    </div>




    
</body>
</html>
