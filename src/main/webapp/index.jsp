<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>INDEX</title>
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




    <c:forEach items="${concerts}" var="concert">
        <div class="w3-panel w3-hover-text-white w3-card w3-yellow w3-hover-orange w3-padding">
           <p>
               <a href="/concert?id=${concert.getId()}">Выступает: ${concert.getArtist()} Когда:${concert.getConcertDate()}</a>
               <c:if test="${user} != null">
                   <c:if test="${user.getRole().equals(\"ADMIN\")}">
                       <a  class="w3-button w3-circle w3-xlarge w3-red w3-ripple w3-margin-left w3-right"><i>X</i></a>
                   </c:if>
               </c:if>
           </p>

        </div>
    </c:forEach>
    <br>

    <c:if test="${user!=null}">
        <c:if test="${user.getRole().equals(\"ADMIN\")}">
            <a class="w3-button w3-circle w3-xlarge w3-red w3-ripple w3-margin-left" href="/billboard/admin/add?entity=concert"><i>+</i></a>
        </c:if>
    </c:if>














</body>
</html>