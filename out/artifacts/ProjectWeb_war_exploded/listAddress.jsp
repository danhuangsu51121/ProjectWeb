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
    <title>地址列表</title>
</head>
<body>
<table width="600px" border="1px" align="center">
    <tr>
        <th>Detail</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Level</th>
        <th>Operation</th>
    </tr>
    <c:if test="${not empty list}">
        <c:forEach items="${list}" var="address">
            <tr>
                <td>${address.detail}</td>
                <td>${address.name}</td>
                <td>${address.phone}</td>
                <td>${address.level}</td>
                <td>
                    <a href="address.action?method=deleteAddress&id=${address.id}">删除</a>
                    <a href="address.action?method=modifyAddress&id=${address.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<h1 align="center">
    <a href="addAddress.jsp" >添加新地址</a>
</h1>

</body>
</html>
