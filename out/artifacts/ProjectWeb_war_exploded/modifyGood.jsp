<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anonymous
  Date: 2020/9/9
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更改商品相关信息</title>
</head>
<body>
<form action="good.action?method=updateGood&id=${good.id}" method="post">
    <table width="600px" border="1px" align="center">

        <tr>
            <td>ID</td>
            <td>${good.id}</td>
        </tr>

        <tr>
            <td>商品名</td>
            <td><input type="text" name="name" value="${good.name}"></td>
        </tr>

        <tr>
            <td>上架时间</td>
            <td><input type="date" name="pubdate" value="${good.pubdate}"></td>
        </tr>

        <tr>
            <td>商品展示图</td>
            <td><input type="text" name="picture" value="${good.picture}"></td>
        </tr>

        <tr>
            <td>价格</td>
            <td><input type="text" name="price" value="${good.price}"></td>
        </tr>

        <tr>
            <td>评分</td>
            <td><input type="text" name="star" value="${good.star}"></td>
        </tr>

        <tr>
            <td>商品详情</td>
            <td><input type="text" name="info" value="${good.info}"></td>
        </tr>

        <tr>
            <td>商品类型</td>
            <td><input type="text" name="typeid" value="${good.typeid}"></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>

    </table>
</form>
</body>
</html>
