<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/billboard/admin/update?entity=ticket&id=${ticket.getId()}">
        Категория: <input type="text" value="${ticket.getCategory()}" name="category"/> <br/>
        Стоимость: <input type="text" value="${ticket.getCost()}" name="cost"/> <br/>
        Количество: <input type="text" value="${ticket.getAmount()}" name="amount"/>
        <input type="submit" value="Принять" />
    </form>
</body>
</html>
