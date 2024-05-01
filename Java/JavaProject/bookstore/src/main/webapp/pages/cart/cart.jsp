<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%--静态包含,引入相同的头部--%>
	<%@ include file="/pages/common/head.jsp"%>

	<script type="text/javascript">
		$(function () {
			$(".itemCount").change(function () {
                var bookId = $(this).attr("bookId")
                var count = $(this).val()
                if (confirm("你确定要修改【"+ $(this).parent().parent().find("td:first").text() +"】的商品数量为" + count)) {

                    location.href = "http://localhost:8080/bookstore/cart?action=updateItem&id=" + bookId+ "&count=" + count;
                } else{
                    //如果取消，则让数量保持原来的值
                    this.value = this.defaultValue;
				}
            });

			$("a.clearCart").click(function () {
				confirm("您确定要清空购物车吗")
            })

			$("a.deleteItem").click(function () {
				confirm("您确定要删除【"+ $(this).parent().parent().find("td:first").text() +"】吗")
            })
        })
	</script>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%--静态包含欢迎菜单--%>
		<%@ include file="/pages/common/welcom.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
            <c:if test="${empty sessionScope.cart.items}">
                <tr>
                    <td colspan="5"><a href="index.jsp">快去选购商品吧!!!</a></td>
                </tr>
            </c:if>
			<c:if test="${not empty sessionScope.cart.items}">
				<c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td><input bookId="${entry.value.id}" type="text" class="itemCount" name="count" value="${entry.value.count}"></td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a class="deleteItem" href="cart?action=deleteItem&id=${entry.value.id}">删除</a></td>
                </tr>
            </c:forEach>
            </c:if>



			
		</table>
		
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a class="clearCart" href="cart?action=clearCart">清空购物车</a></span>
			<span class="cart_span"><a href="order?action=createOrder">去结账</a></span>
		</div>
	
	</div>

	<%--静态包含页脚--%>
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>