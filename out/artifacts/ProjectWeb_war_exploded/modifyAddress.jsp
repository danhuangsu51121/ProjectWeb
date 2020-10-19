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
    <title>更改地址相关信息</title>
</head>
<body>
<form action="address.action?method=updateAddress&id=${address.id}&uid=${address.uid}" method="post">
    <table width="600px" border="1px" align="center">

        <tr>
            <td>详细地址</td>
            <td><input type="text" name="detail" value="${address.detail}"></td>
        </tr>

        <tr>
            <td>收件人姓名</td>
            <td><input type="text" name="name" value="${address.name}"></td>
        </tr>

        <tr>
            <td>手机号</td>
            <td><input type="text" name="phone" value="${address.phone}"></td>
        </tr>

        <tr>
            <td>地址的顺序1最高</td>
            <td><input type="text" name="level" value="${address.level}"></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>

    </table>
</form>
</body>
</html>
