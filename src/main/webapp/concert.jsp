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
    Где: <a href="/concerthall?name=${concert_description.getConcertHallName()}"><c:out value="${concert_description.getConcertHallName()}"/></a><br/>
    Адрес: <c:out value="${concert_description.getAddress()}"/><br/>
    Промо-группа: <a href="promogroup?name=${concert_description.getPromoGroupName()}"><c:out value="${concert_description.getPromoGroupName()}"/></a><br/>
    Описание: <c:out value="${concert_description.getDescription()}"/><br/>
    <p>Билеты</p>
    <c:forEach items="${concert_description.getTickets()}" var="ticket">
        <p>
            Тип: ${ticket.getCategory()} Цена: ${ticket.getCost()} Осталось: ${ticket.getAmount()}
            <c:if test="${user != null}">
                <form method="post" action="/concert?ticketId=${ticket.getId()}" >
                    Количество: <input type="number" name="amount" /> <br/>
                    <input type="submit" value="Купить"/>
                </form>
            </c:if>
        </p>
    </c:forEach>
    <br/>
    <c:if test="${user != null}">
        <c:if test="${user.getRole().equals(\"ADMIN\")}">
            <a href="/billboard/admin/update?entity=concert&id=${concert_description.getConcertId()}">Изменить</a>
        </c:if>
    </c:if>


    
    



</body>
</html>
