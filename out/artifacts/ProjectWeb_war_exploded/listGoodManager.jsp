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
    <title>管理员的商品列表界面</title>
</head>
<body>
<table width="950px" border="1px" align="center">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>PubDate</th>
        <th>Picture</th>
        <th>Price</th>
        <th>Star</th>
        <th>Info</th>
        <th>TypeId</th>
        <th>Operation</th>
    </tr>
    <c:if test="${not empty list}">
        <c:forEach items="${list}" var="good">
            <tr>
                <td align="center">${good.id}</td>
                <td align="center">${good.name}</td>
                <td align="center">${good.pubdate}</td>
                <td style="word-break: break-all" width="250px">${good.picture}</td>
                <td align="center">${good.price}</td>
                <td align="center">${good.star}</td>
                <td align="center">${good.info}</td>
                <td align="center">${good.typeid}</td>

                <td>
                    <a href="good.action?method=deleteGood&id=${good.id}">删除</a>
                    <a href="good.action?method=modifyGood&id=${good.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
