<%--
  Created by IntelliJ IDEA.
  User: Winterfell
  Date: 2021/10/31
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>

<%--
    contentType:回传数据内容类型.即在jsp源码中service方法resp设置contentType
    language:表示jsp页面源码的语言,暂时只支持Java
    import:就是像Java代码一样导包或者类
    pageEncoding:设置当前jsp页面的编码
    errorPage:设置当前页面出错,去往哪个错误页面.(jsp本质上是servlet,所以这里的/就是http://ip:port/工程路径/)
    isErrorPage:表示当前页面是否是错误页面,默认为false
    buffer:设置jsp源码out输出流的缓存区大小,默认为8kb
    autoFlush:设置jsp源码out输出流缓存区满了之后是否自动刷新,默认为true
    isELIgnored:设置jsp页面是否忽略EL表达式
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    hello jsp

    <%--声明式脚本(极少使用) ==>声明翻译的java类中的成员,如属性,方法,代码块,内部类等--%>
    <%!
        private String username;

        public void fun() {

        }
        {
            username = "李四";
        }
        class innerClass{

        }
    %>


    <%--表达式脚本(常用) ==> 用于在页面直接打印表达式
        注:①不要加; 因为它在out.print(xxx)中
           ②它在service方法中,方法中的形参和局部变量都可以使用.如request,response
    --%>
    <%=
        username
    %>
    <%=
        request.getParameter("username")
    %>

    <%--代码脚本(常用) ==>写java代码
        注: ①多段代码脚本可以组合使用
            ②它在service方法中,方法中的形参和局部变量都可以使用.如request,response
    --%>
    <%
        for (int i = 0; i < 10; i++) {
    %>
        <%=
            i
        %>
<br>
    <%
        }
    %>

</body>
</html>
