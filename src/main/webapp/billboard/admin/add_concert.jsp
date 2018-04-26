<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить концерт</title>
    <link rel="stylesheet" type="text/css" href="https://www.w3schools.com/w3css/4/w3.css">
    <style> a { text-decoration: none } .w3-input {width: 200px} </style>
</head>
<body>
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
<form class="w3-margin-top" method="post" action="/billboard/admin/add?entity=concert" >
    <br><label>Выступает</label><input class="w3-input w3-margin-left" type="text" name="artist"/> <br/>
    <br><label>Дата</label><input class="w3-input w3-margin-left" type="datetime-local" name="date" /><br/>
    <br><label>Возрастное ограничение</label><input class="w3-input w3-margin-left" type="number" name="age_constr" /><br/>
    <br><label>Промо-группа</label><select size="1" class="w3-input w3-margin-left" name="promo_group_select"">
    <c:forEach items="${promo_groups}" var="promo_group">
        <option value="${promo_group.getName()}">${promo_group.getName()}</option>
    </c:forEach>
</select> <br/>
    <br><label>Описание</label><input class="w3-input w3-margin-left" type="text" name="descr"> <br/>
    <br><label>Где</label><select size="1" class="w3-input w3-margin-left" class="w3-input w3-margin-left" name="concert_hall_select" value="${concert_description.getConcertHallName()}">
    <c:forEach items="${concert_halls}" var="concert_hall">
        <option value="${concert_hall.getName()}">${concert_hall.getName()}</option>
    </c:forEach>
</select><br/><br/>
    <input class="w3-button w3-yellow w3-hover-orange w3-margin w3-round" type="submit" value="Добавить" name="toAcceptChanges"/>
</form>

</body>
</html>
