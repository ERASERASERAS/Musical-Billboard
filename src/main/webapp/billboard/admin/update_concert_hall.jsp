<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/billboard/admin/update?entity=concert_hall?&id=${concert_hall.getId()}">
        Название: <input type="text" value="${concert_hall.getId()}" name="name"/> <br/>
        Адрес: <input type="text" value="${concert_hall.getAddress()}" name="address"/> <br/>
        Телефон: <input type="text" value="${concert_hall.getTelephone()}" name="telephone"/> <br/>
        E-mail: <input type="text" value="${concert_hall.getEmail()}" name="email"/> <br/>
        <input type="submit" value="Принять" />
    </form>
</body>
</html>
