<%--
  Created by IntelliJ IDEA.
  User: Winterfell
  Date: 2021/11/1
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    头部信息 <br/>
    主体信息 <br/>
    <%--
        静态包含(常用)
        ①静态包含不会生成引入文件的java代码
        ②静态包含就是将引入文件的java代码复制到此页面java代码中
        ③file属性指定引用文件路径,/同样表示http://ip:port/工程路径/,映射到web目录下
    --%>
    <%--<%@include file="/include/footer.jsp" %>--%>

    <%--
        动态包含(不常用)
        ①动态包含会生成引入文件的java代码文件
        ②此页面通过JspRuntimeLibrary.include(request, response, "/include/footer.jsp", out, false);引入其它jsp文件
        ③由上述代码得,两个页面共享request,response,out对象,out对象共享一个缓冲区.
    --%>
    <jsp:include page="/include/footer.jsp"/>
</body>
</html>
