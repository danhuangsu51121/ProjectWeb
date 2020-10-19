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
    <title>用户的商品列表界面</title>
</head>
<body>
<table width="950px" border="1px" align="center">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>info</th>
        <th>Operation</th>
    </tr>
    <c:if test="${not empty list}">
        <c:forEach items="${list}" var="good">
            <tr>
                <td align="center">${good.name}</td>
                <td align="center">${good.price}</td>
                <td align="center">${good.info}</td>

                <td align="center">
                    <a href="good.action?method=listGoodByid&id=${good.id}">查看详情</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
