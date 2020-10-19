<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>更改订单状态</title>
</head>
<body>

<form action="order.action?method=updateOrder" method="post">
    <table width="600px" border="1px" align="center">

        <tr>
            <td>订单编号</td>
            <td>${order.id}</td>
            <input type="hidden" name="id" value="${order.id}">
        </tr>

        <tr>
            <td>用户编号</td>
            <td>${order.uid}</td>
            <input type="hidden" name="uid" value="${order.uid}">
        </tr>

        <tr>
            <td>总金额</td>
            <td>${order.money}</td>
            <input type="hidden" name="money" value="${order.money}">
        </tr>

        <tr>
            <td>目前状态编号</td>
            <td>${order.status}</td>
        </tr>

        <tr>
            <td>更改订单状态为</td>
            <td><select name="status">
                <option value="0" selected>未支付</option>
                <option value="1">支付失败</option>
                <option value="2">支付成功</option>
                <option value="3">发货</option>
                <option value="4">到货</option>
                <option value="5">评价</option>
            </select></td>
        </tr>

        <tr>
            <td>下单时间</td>
            <td>${order.time}</td>
            <input type="hidden" name="time" value="${order.time}">
        </tr>

        <tr>
            <td>地址序号</td>
            <td>${order.aid}</td>
            <input type="hidden" name="aid" value="${order.aid}">
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="确认"></td>
        </tr>
    </table>
</form>



</body>
</html>