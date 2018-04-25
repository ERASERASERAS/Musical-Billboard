<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить билет</title>
</head>
<body>
    <form method="post" action="/billboard/admin/add?entity=ticket&concertId=${concert.getId()}">
        Категория: <input type="text" name="category" /> <br/>
        Стоимость: <input type="text" name="cost" /> <br/>
        Количество: <input type="text" name="amount" /> <br/>
        <input type="submit" value="Добавить" />
    </form>
</body>
</html>
