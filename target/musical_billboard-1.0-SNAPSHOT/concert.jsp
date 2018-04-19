<%--
  Created by IntelliJ IDEA.
  User: yar
  Date: 17.04.2018
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title></title>
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
    <br/><br/>
    <c:out value="${concert_description.getArtistName()}"/>
    <c:out value="${concert_description.getConcertDate()}"/>
    <c:out value="${concert_description.getConcertHallName()}"/>
    <c:out value="${concert_description.getAddress()}"/>
    <c:out value="${concert_description.getPromoGroupName()}"/>
    <c:out value="${concert_description.getDescription()}"/>
    <p>Билеты</p>
    <c:forEach items="${concert_description.getTickets()}" var="ticket">
        <p>Тип: ${ticket.getCategory()} Цена: ${ticket.getCost()} Осталось: ${ticket.getAmount()}
        </p>
    </c:forEach>


    
    



</body>
</html>
