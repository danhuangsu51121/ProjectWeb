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
    <title>订单列表</title>
    <style>
        td {
            text-align: center;
        }
    </style>
</head>
<body>
<table width="800px" border="1px" align="center">
    <tr>
        <th width="40px">订单序号</th>
        <th width="80px">用户序号</th>
        <th width="80px">总金额</th>
        <th width="80px">订单状态</th>
        <th width="40px">时间</th>
        <th width="80px">地址编号</th>
        <th width="100px">操作</th>
    </tr>
    <c:if test="${not empty list}">
        <c:forEach items="${list}" var="order">
            <tr>
                <td align="center">${order.id}</td>
                <td>${order.uid}</td>
                <td>${order.money}</td>
                <c:if test="${0 == order.status}">
                    <td align="center">未支付</td>
                </c:if>
                <c:if test="${1 == order.status}">
                    <td align="center">支付失败</td>
                </c:if>
                <c:if test="${2 == order.status}">
                    <td align="center">支付成功</td>
                </c:if>
                <c:if test="${3 == order.status}">
                    <td align="center">发货</td>
                </c:if>
                <c:if test="${4 == order.status}">
                    <td align="center">到货</td>
                </c:if>
                <c:if test="${5 == order.status}">
                    <td align="center">评价</td>
                </c:if>


                <td>${order.time}</td>
                <td>${order.aid}</td>
                <td align="center">
                    <a href="order.action?method=deleteOrderById&id=${order.id}">删除</a>
                    <a href="order.action?method=modifyOrderStatus&id=${order.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>

</body>
</html>