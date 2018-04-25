<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/billboard/admin/update?entity=promo_group&id=${promo_group.getId()}">
        Название: <input type="text" value="${promo_group.getName()}" name="name"/> <br/>
        Email: <input type="text" value="${promo_group.getEmail()}" name="email"/> <br/>
        Телефон: <input type="text" value="${promo_group.getTelephone()}" name="telephone"> <br/>
        <input type="submit" value="Принять"/>
    </form>
</body>
</html>
