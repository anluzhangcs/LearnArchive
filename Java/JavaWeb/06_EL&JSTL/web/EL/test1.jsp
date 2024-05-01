<%--
  Created by IntelliJ IDEA.
  User: Winterfell
  Date: 2021/11/1
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--先往域对象中存储数据--%>
    <%
        pageContext.setAttribute("key", "pageContext");
        request.setAttribute("key", "request");
        session.setAttribute("key", "session");
        application.setAttribute("key", "application");

    %>
    <%--通过EL表达式取数据
        -EL表达式主要就是用于输出域数据的
        -El表达式:${key},当多个域对象中有key相同的数据时,EL表达式会按照域的范围从小到大取
    --%>
    ${ key}


</body>
</html>
