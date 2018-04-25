<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить концертный зал</title>
</head>
<body>
    <form method="post" action="/billboard/admin/add?entity=concert_hall">
        Название: <input type="text" name="name" /> <br/>
        Адрес: <input type="text" name="address" /> <br/>
        Телефон: <input type="text" name="telephone" /> <br/>
        E-mail: <input type="text" name="email" /> <br/>
        <input type="submit" value="Добавить"/>
    </form>
</body>
</html>