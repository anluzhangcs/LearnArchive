<%--
  Created by IntelliJ IDEA.
  User: Winterfell
  Date: 2021/11/5
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <base href="http://localhost:8080/07_cookie&session/"/>
  </head>
  <body>
  <form action="login" method="post">
    <%--cookie是Map<String,Cookie>--%>
    <input type="text" username="username"  value="${cookie.username.value}">
    <input type="password" username="password"  >
    <input type="submit" value="登录">
  </form>
  </body>
</html>
