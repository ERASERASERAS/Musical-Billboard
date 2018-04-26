<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование концертного зала</title>
    <link rel="stylesheet" type="text/css" href="https://www.w3schools.com/w3css/4/w3.css">
    <style> a { text-decoration: none } .w3-input {width: 200px} </style>
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
    <form class="w3-margin-top" method="post" action="/billboard/admin/update?entity=concert_hall?&id=${concert_hall.getId()}">
        <br><label>Название</label>
        <input class="w3-input w3-margin-left" type="text" value="${concert_hall.getId()}" name="name"/> <br/>
        <br><label>Адрес</label>
        <input class="w3-input w3-margin-left" type="text" value="${concert_hall.getAddress()}" name="address"/> <br/>
        <br><label>Телефон</label>
        <input class="w3-input w3-margin-left" type="text" value="${concert_hall.getTelephone()}" name="telephone"/> <br/>
        <br><label>E-mail</label>
        <input type="text" value="${concert_hall.getEmail()}" name="email"/> <br/>
        <input class="w3-button w3-yellow w3-hover-orange w3-margin w3-round" type="submit" value="Принять" />
    </form>


</body>
</html>
