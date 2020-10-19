<%--
  Created by IntelliJ IDEA.
  User: Anonymous
  Date: 2020/9/9
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车列表</title>
</head>
<style>
    td {
        text-align: center;
    }
</style>
<body>

<table width="800px" border="1px" align="center">
    <tr>
        <th width="40px">用户名</th>
        <th width="80px">商品名</th>
        <th width="80px">数量</th>
        <th width="80px">总金额</th>
        <th width="100px">操作</th>
    </tr>
    <c:if test="${not empty list}">
        <c:forEach items="${list}" var="cart">
            <tr>
                <td>${cart.id}</td>
                <td>${cart.pid}</td>
                <td>${cart.num}</td>
                <td>${cart.money}</td>

                <td align="center">
                    <a href="cart.action?method=deleteCartOne&pid=${cart.pid}&id=${cart.id}">删除该商品</a>
                    <a href="cart.action?method=modifyCart&pid=${cart.pid}&id=${cart.id}">修改数量</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<h3 align="center"><a href="cart.action?method=deleteCartAll&id=${user.id}">清空购物车</a></h3>
<h3 align="center"><a href="order.action?method=linkOrder&uid=${user.id}">生成订单</a></h3>

</body>
</html>