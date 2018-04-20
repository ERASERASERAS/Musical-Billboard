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
                <a href="/login?logout=true">Выход</a>
            </span>
    </c:if>
    <br/><br/>
    Выступает: <c:out value="${concert_description.getArtistName()}"/><br/>
    Дата: <c:out value="${concert_description.getConcertDate()}"/><br/>
    Возрастное ограничение: <c:out value="${concert_description.getAgeConstraint()}"/><br/>
    Где: <c:out value="${concert_description.getConcertHallName()}"/><br/>
    Адрес: <c:out value="${concert_description.getAddress()}"/><br/>
    Промо-группа: <c:out value="${concert_description.getPromoGroupName()}"/><br/>
    Описание: <c:out value="${concert_description.getDescription()}"/><br/>
    <p>Билеты</p>
    <c:forEach items="${concert_description.getTickets()}" var="ticket">
        <p>
            Тип: ${ticket.getCategory()} Цена: ${ticket.getCost()} Осталось: ${ticket.getAmount()}
            <c:if test="${user != null}"><a href="">Купить</a></c:if>
        </p>
    </c:forEach>


    
    



</body>
</html>
