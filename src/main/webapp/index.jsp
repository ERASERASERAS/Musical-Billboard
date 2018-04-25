<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INDEX</title>
    <link rel="stylesheet" type="text/css" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-sand">

    <c:if test="${user == null}">
        <div class="w3-bar w3-teal">
            <a class="w3-bar-item w3-button w3-aqua w3-hover-cian w3-right w3-margin w3-round" href="/login">Войти</a>
            <a class="w3-bar-item w3-button w3-aqua w3-hover-cian w3-right w3-margin-top w3-round" href="/login">Регистрация</a>
        </div>
    </c:if>
    <c:if test="${user != null}">
        <div class="w3-bar w3-teal">
            <a class="w3-bar-item w3-button w3-aqua w3-hover-cian w3-right w3-margin w3-round" href="/billboard/home">Личный кабинет</a>
            <a class="w3-bar-item w3-button w3-aqua w3-hover-cian w3-right w3-margin-top w3-round" href="/login?logout=true">Выйти</a>
        </div>
    </c:if>




    <div class="w3-bar w3-black">
        <a class="w3-bar-item w3-button" href="/">Концерты</a>
        <a class="w3-bar-item w3-button" href="/promo">вававававава</a>
    </div>




    <c:forEach items="${concerts}" var="concert">
        <div class="w3-panel w3-card w3-yellow w3-padding">
            <a href="/concert?id=${concert.getId()}">Выступает: ${concert.getArtist()} Когда:${concert.getConcertDate()}</a>
        </div>
    </c:forEach>
    <br>
    <a class="w3-button w3-circle w3-xlarge w3-red w3-ripple w3-margin-left" href="/add?entity=concert"><i>+</i></a>














</body>
</html>