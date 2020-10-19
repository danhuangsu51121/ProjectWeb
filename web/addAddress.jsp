<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加地址</title>
</head>
<body>
<form action="address.action?method=addAddress" method="post">
    <table width="600px" border="1px" align="center">
        <tr>
            <td>详细地址</td>
            <td><input type="text" name="detail"></td>
        </tr>
        <tr>

        <tr>
            <td>收件人姓名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>手机号</td>
            <td><input type="text" name="phone"></td>
        </tr>


        <input type="hidden" name="uid" value="${user.id}">


        <tr>
            <td>地址优先级</td>
            <td><input type="text" name="level"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>