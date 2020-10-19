<%@ page import="java.util.Date" %>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>提交（添加）订单</title>
</head>
<body>
<%
    Date nowDate = new Date();
    request.setAttribute("nowDate", nowDate);
%>
<%--<%--%>
<%--    long date = new Date().getTime(); request.setAttribute("date", date);--%>
<%--%>--%>
<form action="order.action?method=addOrder" method="post">
    <table width="600px" border="1px" align="center">

        <tr>
            <td>用户名</td>
            <td>${user.username}</td>
        </tr>

        <tr>
            <td>总金额</td>
            <td><input type="text" name="money" value="${money}"></td>
        </tr>

        <tr>
            <td>收货地址</td>
            <td><select name="aid">
                <c:if test="${not empty list2}">
                    <c:forEach items="${list2}" var="address">
                        <option value="${address.id}">${address.detail}</option>
                    </c:forEach>
                </c:if>
            </select></td>
        </tr>


        <input type="hidden" name="status" value="0">
        <input type="hidden" name="time" value="${nowDate}">
        <input type="hidden" name="uid" value="${user.id}">

        <tr>
            <td colspan="2"><input type="submit" value="确认"></td>
        </tr>
    </table>
</form>

</body>
</html>