<%@ page import="java.io.PrintWriter" %><%--
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
    <%
        //先给域对象存储数据
        pageContext.setAttribute("key", "pageContext");
        request.setAttribute("key", "request");
        session.setAttribute("key", "session");
        application.setAttribute("key", "application");
    %>

    <%--取数据并进行输出--%>
    pageContext域对象的值是:<%=pageContext.getAttribute("key")%> <br>
    request域对象的值是:<%=request.getAttribute("key")%> <br/>
    session域对象的值是:<%=session.getAttribute("key")%> <br/>
    application域对象的值是:<%=application.getAttribute("key")%> <br/>

    <%
//        request.getRequestDispatcher("/scope2.jsp").forward(request,response);

    %>

    <%--请求转发标签:作用和request.getRequestDispatcher("/scope2.jsp").forward(request,response);一样--%>
    <jsp:forward page="/scope2.jsp"/>

        <%--
            out对象和response.getWriter的联系和区别
                ①out对象是JspWriter实现类对象,response.getWriter是PrintWriter对象
                ②当jsp页面代码执行完后,out会刷新它自己的缓存区,将缓存区的数据追加到response.getWriter.然后由response.getWriter
                输出流统一刷新缓存区,将输入显示到客户端.
                ③jsp中应该和源码统一,使用out进行输出数据,避免数据内容打乱
                ④jsp中使用out应注意,write()方法只用来输出字符串,如果输出其它类型,会转化为对应的ASCII码.print()方法都可以

        --%>

</body>
</html>
