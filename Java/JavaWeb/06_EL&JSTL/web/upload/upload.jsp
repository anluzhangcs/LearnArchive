<%--
  Created by IntelliJ IDEA.
  User: Winterfell
  Date: 2021/11/2
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        上传数据
        条件:
            ①要有一个form表单
            ②method为post(get方法请求参数长度有限制)
            ③enctype属性必须有,且值必须为multipart/form-data
            ④上传标签类型为file
    --%>
    <form action="http://localhost:8080/06_EL&JSTL/uplaod" method="post" enctype="multipart/form-data">
        用户名:<input type="text" username="username" > <br/>
        头像:<input type="file" username="avatar"><br/>
        <input type="submit" value="上传"><br/>
    </form>
</body>
</html>
