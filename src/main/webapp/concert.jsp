<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Концерт</title>
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
    <br/><br/>


<div class="w3-panel w3-hover-text-white w3-card w3-yellow w3-hover-orange w3-padding"><p>Выступает: <c:out value="${concert_description.getArtistName()}"/></p></div>
    <div class="w3-panel w3-hover-text-white w3-card w3-yellow w3-hover-orange w3-padding"><p>Дата: <c:out value="${concert_description.getConcertDate()}"/></p></div>
<div class="w3-panel w3-hover-text-white w3-card w3-yellow w3-hover-orange w3-padding">Возрастное ограничение: <c:out value="${concert_description.getAgeConstraint()}"/></div>
<div class="w3-panel w3-hover-text-white w3-card w3-yellow w3-hover-orange w3-padding">Где: <a href="/concerthall?name=${concert_description.getConcertHallName()}"><c:out value="${concert_description.getConcertHallName()}"/></a></div>
<div class="w3-panel w3-hover-text-white w3-card w3-yellow w3-hover-orange w3-padding">Адрес: <c:out value="${concert_description.getAddress()}"/></div>
<div class="w3-panel w3-hover-text-white w3-card w3-yellow w3-hover-orange w3-padding">Промо-группа: <a href="promogroup?name=${concert_description.getPromoGroupName()}"><c:out value="${concert_description.getPromoGroupName()}"/></a></div>
<div class="w3-panel w3-hover-text-white w3-card w3-yellow w3-hover-orange w3-padding">Описание: <c:out value="${concert_description.getDescription()}"/></div>
    <p>Билеты</p>
    <c:if test="${user != null}">
        <c:if test="${user.getRole().equals(\"ADMIN\")}">
            <div class="w3-panel w3-hover-text-white w3-card w3-light-green w3-hover-green w3-padding"><a href="/billboard/admin/add?entity=ticket&concertId=${concert_description.getConcertId()}"> Добавить билет</a></div>
        </c:if>
    </c:if>
    <c:forEach items="${concert_description.getTickets()}" var="ticket">
        <p>
        <div class="w3-panel w3-hover-text-white w3-card w3-pale-green w3-hover-green w3-padding">Тип: ${ticket.getCategory()} Цена: ${ticket.getCost()} Осталось: ${ticket.getAmount()}</div>
            <c:if test="${user != null}">
                <form method="post" action="/concert?ticketId=${ticket.getId()}" >
                    <div class="w3-panel w3-hover-text-white w3-card w3-pale-green w3-hover-green w3-padding">Количество: <input type="number" name="amount" /> </div>
                    <input class="w3-btn w3-orange w3-hover-red w3-hover-text-white w3-round" type="submit" value="Купить"/>
                </form>

                <c:if test="${user != null}">
                    <c:if test="${user.getRole().equals(\"ADMIN\")}">
                        <a class="w3-btn w3-orange w3-hover-red w3-hover-text-white w3-round" href="/billboard/admin/update?entity=ticket&id=${ticket.getId()}"> Отредактировать билет</a>
                    </c:if>
                </c:if>
            </c:if>
        </p>
    </c:forEach>

    <br/>
    <c:if test="${user != null}">
        <c:if test="${user.getRole().equals(\"ADMIN\")}">
            <a class="w3-btn w3-orange w3-hover-red w3-hover-text-white w3-round" href="/billboard/admin/update?entity=concert&id=${concert_description.getConcertId()}">Отредактировать концерт</a>
        </c:if>
    </c:if>

    <c:if test="${user != null}">
        <c:if test="${user.getRole().equals(\"ADMIN\")}">
            <a class="w3-btn w3-orange w3-hover-red w3-hover-text-white w3-round w3-margin-left" href="/billboard/admin/delete?entity=concert&id=${concert_description.getConcertId()}">Удалить концерт</a>
        </c:if>
    </c:if>


    
    



</body>
</html>
