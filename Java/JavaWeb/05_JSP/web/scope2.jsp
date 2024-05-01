<%--
  Created by IntelliJ IDEA.
  User: Winterfell
  Date: 2021/11/1
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>测试域对象的作用范围</h1>

    <%--取数据并进行输出--%>
    pageContext域对象的值是:<%=pageContext.getAttribute("key")%> <br>
    request域对象的值是:<%=request.getAttribute("key")%> <br/>
    session域对象的值是:<%=session.getAttribute("key")%> <br/>
    application域对象的值是:<%=application.getAttribute("key")%> <br/>

</body>
</html>
