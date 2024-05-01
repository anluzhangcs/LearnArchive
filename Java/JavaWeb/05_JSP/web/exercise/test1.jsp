<%--
  Created by IntelliJ IDEA.
  User: Winterfell
  Date: 2021/11/1
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>在jsp页面中输出九九乘法表</h1>

    <%
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
    %>

    <%=
        i+"*"+j+"="+i*j
    %>

    <%
            }
    %>
    <br/>
    <%
        }

    %>

<br/>
    <table align="center">
        <%-- 外层循环遍历行 --%>
        <% for (int i = 1; i <= 9; i++) { %>
        <tr>
            <%-- 内层循环遍历单元格 --%>
            <% for (int j = 1; j <= i ; j++) { %>
            <td><%=j + "x" + i + "=" + (i*j)%></td>
            <% } %>
        </tr>
        <% } %>
    </table>
</body>
</html>
