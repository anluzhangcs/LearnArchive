<%--
  Created by IntelliJ IDEA.
  User: Winterfell
  Date: 2021/11/3
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
    动态base标签
    http://ip:port/工程路径/
    getScheme()     获取协议
--%>
<%

    String base = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + request.getContextPath()+"/";
%>

<%--抽取头部相同的部分--%>
<base href="<%=base%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
