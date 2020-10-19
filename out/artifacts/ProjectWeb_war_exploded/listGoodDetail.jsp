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
    <style>
        img{
            width:140px;
            height:100px;
            border:#003366 1px solid;
            overflow: hidden;/*超出部分自动隐藏*/
        }
    </style>


    <title>商品细节</title>
</head>
<body>
<table width="950px" border="1px" align="center">
    <tr>
        <th>Name</th>
        <th>PubDate</th>
        <th>Picture</th>
        <th>Price</th>
        <th>Star</th>
        <th>Info</th>
        <th>Operation</th>
    </tr>

    <tr>
        <td align="center">${good.name}</td>
        <td align="center">${good.pubdate}</td>
        <td align="center">
            <img src="${good.picture}" alt="">
        </td>
        <td align="center">${good.price}</td>
        <td align="center">${good.star}</td>
        <td align="center">${good.info}</td>
        <td align="center">
            <a href="index.jsp">返回主页</a>
            <a href="cart.action?method=linkCart&pid=${good.id}&uid=${user.id}&price=${good.price}&name=${good.name}">想要</a>
        </td>
    </tr>

</table>

</body>
</html>
