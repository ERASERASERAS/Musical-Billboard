<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/billboard/admin/update?entity=concert&id=${concert_description.getConcertId()}" >
        Выступает: <input type="text" name="artist" value="${concert_description.getArtistName()}"/> <br/>
        Дата: <input type="datetime-local" name="date" value="${concert_description.getConcertDate()}"/><br/>
        Возрастное ограничение: <input type="number" name="age_constr" value="${concert_description.getAgeConstraint()}"/><br/>
        Промо-группа: <select size="1" name="promo_group_select" value="${concert_description.getPromoGroupName()}">
                        <c:forEach items="${promo_groups}" var="promo_group">
                            <option value="${promo_group.getName()}">${promo_group.getName()}</option>
                        </c:forEach>
                    </select> <br/>
        Описание: <input type="text" name="descr" value="${concert_description.getDescription()}"> <br/>
        Где: <select size="1" name="concert_hall_select" value="${concert_description.getConcertHallName()}">
                <c:forEach items="${concert_halls}" var="concert_hall">
                    <option value="${concert_hall.getName()}">${concert_hall.getName()}</option>
                </c:forEach>
                </select><br/><br/>
        <input type="submit" value="Принять" name="toAcceptChanges"/>
    </form>

</body>
</html>
