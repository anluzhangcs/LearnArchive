<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Winterfell
  Date: 2021/11/2
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        if标签:用于判断
        属性:
            test:为判断的表达式,用EL表达式输出

    --%>
    <c:if test="${12 == 12}">
        <h1>12等于12</h1>
    </c:if>


    <hr>
    <%--
        choose-when-otherwise标签,类似于switch-case-default
            -when标签表示某个情况,父标签必须是choose
            -when判断成功不会继续判断下面的条件,相当于break

    --%>
    <%
        request.setAttribute("age",21);
    %>
    <c:choose>
        <c:when test="${requestScope.age>=14 && requestScope.age<18 }">
            <h1>青年</h1>
        </c:when>
        <c:when test="${requestScope.age>=18 && requestScope.age<30}">
            <h1>少年</h1>
        </c:when>
        <c:when test="${requestScope.age>=30 && requestScope.age<50}">
            <h1>中年</h1>
        </c:when>
        <c:otherwise>
            <h1>老年</h1>
        </c:otherwise>
    </c:choose>

    <hr>

    <%--
        forEach遍历标签:
        属性:
            items:表示遍历的数据源,可以是数组,集合
            var:表示当前遍历的数据,也表示遍历的变量名
            begin:表示遍历开始索引,默认从0开始
            end:表示遍历结束索引
            step:表示遍历步长,即i++操作,默认为1
    --%>
    <%
        List<String> names = Arrays.asList("zhangsna", "lisi", "wangwu");
        request.setAttribute("names",names);
    %>
    <c:forEach items="${requestScope.names}" var="username" begin="0" end="2" step="1" >
        ${username}<br>
    </c:forEach>

</body>
</html>
