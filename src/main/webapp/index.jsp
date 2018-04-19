<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INDEX</title>
</head>
<body>
<h1>HELLO NEZNAKOMETS</h1> <br/>
    <a href="/login">АВТОРИЗАЦИЯ/РЕГИСТРАЦИЯ</a>

    <%! int i = 3;%>

    <% for(int j =0; j < i; j++)
        out.println(j + "\n");
        out.newLine();
        out.println("<br/>");
        out.write("<br/>");
    %>


</body>
</html>