<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        a { text-decoration: none }
        #ff {
            width: 200px;
        }
        #ff1 {
            width: 200px;
        }

    </style>
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


    <form class="w3-container w3-margin-top" method="post" action="/login" >
        <input class="w3-input" type="text" name="login" placeholder="Логин" id="ff"/> <br/>
        <input class="w3-input" type="password" name="password" placeholder="Пароль" id="ff1"/> <br/>
        <input class="w3-button w3-yellow w3-hover-orange w3-margin-right w3-round" type="submit" value="Войти" name="doLogin"/>
        <input class="w3-button w3-yellow w3-hover-orange w3-margin w3-round" type="submit" value="Регистрация" name="doRegister">
    </form>


</body>
</html>
