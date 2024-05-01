<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Winterfell
  Date: 2021/11/4
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="page_nav">
    <c:if test="${requestScope.page.pageNumber > 1}">
        <a href="${requestScope.page.url}&pageNumber=1">首页</a>
        <a href="${requestScope.page.url}&pageNumber=${requestScope.page.pageNumber-1}">上一页</a>
    </c:if>

    <%--要求分页条为5个,当前页在中间--%>
    <c:choose>
        <%--总页数小于等于5--%>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <%--存取begin和end--%>
            <c:set scope="page" var="begin" value="1"/>
            <c:set scope="page" var="end" value="5"/>
        </c:when>
        <%--总页数大于5,以10页为例--%>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <%--当前页<=3,就遍历1-5--%>
                <c:when test="${requestScope.page.pageNumber <= 3}">
                    <c:set scope="page" var="begin" value="1"/>
                    <c:set scope="page" var="end" value="5"/>
                </c:when>
                <%--当前页在8，9，10，遍历6-10--%>
                <c:when test="${requestScope.page.pageNumber >= requestScope.page.pageTotal-2}">
                    <c:set scope="page" var="begin" value="${requestScope.page.pageTotal-4}"/>
                    <c:set scope="page" var="end" value="${requestScope.page.pageTotal}"/>
                </c:when>
                <%--其他情况--%>
                <c:otherwise>
                    <%--存取begin和end--%>
                    <c:set scope="page" var="begin" value="${requestScope.page.pageNumber-2}"/>
                    <c:set scope="page" var="end" value="${requestScope.page.pageNumber+2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <%--对遍历分页进行抽取，不一样的只有begin，end--%>
    <c:forEach  begin="${pageScope.begin}" end="${pageScope.end}" var="i">
        <c:if test="${requestScope.page.pageNumber == i}">
            【${i}】
        </c:if>
        <c:if test="${requestScope.page.pageNumber != i}">
            <a href="${requestScope.page.url}&pageNumber=${i}">${i}</a>
        </c:if>
    </c:forEach>

    <c:if test="${requestScope.page.pageNumber <  requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNumber=${requestScope.page.pageNumber+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNumber=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，{${requestScope.page.itemCount}}条记录 到第<input value="${requestScope.page.pageNumber}" name="pn" id="pn_input"/>页
    <input id="moveToPage" type="button" value="确定">

    <script type="text/javascript">
        $(function () {
            $("#moveToPage").click(function () { //给跳转按钮绑定单击事件


                location.href = "${requestScope.page.url}&pageNumber="+$("#pn_input").val();

            });
        })
    </script>
</div>

</body>
</html>
