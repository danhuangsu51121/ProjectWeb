<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>添加管理员用户</title>
</head>
<body>
<form action="user.action?method=addUser" method="post">
    <table width="600px" border="1px" align="center">

        <tr>
            <td>姓名</td>
            <td><input type="text" name="username"></td>
        </tr>

        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>

        <tr>
            <td>邮箱</td>
            <td><input type="email" name="email"></td>
        </tr>

        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="gender" value="男">汉子
                <input type="radio" name="gender" value="女">妹子
            </td>
        </tr>

        <input type="hidden" name="role" value="0">

        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>