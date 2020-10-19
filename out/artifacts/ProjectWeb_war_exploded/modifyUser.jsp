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
    <title>用户信息修改</title>
</head>
<body>
<form action="user.action?method=updateUser&id=${user.id}" method="post">
    <table width="600px" border="1px" align="center">

        <tr>
            <td>ID</td>
            <td>${user.id}</td>
        </tr>

        <tr>
            <td>姓名</td>
            <td><input type="text" name="username" value="${user.username}"></td>
        </tr>

        <tr>
            <td>密码</td>
            <td><input type="password" name="password" value="${user.password}"></td>
        </tr>

        <tr>
            <td>邮件</td>
            <td><input type="email" name="email" value="${user.email}"></td>
        </tr>

        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="gender" value="男" checked>汉子
                <input type="radio" name="gender" value="女">妹子
            </td>
        </tr>


        <c:if test="${0 == user.role}">
            <tr>
                <td>角色标识</td>
                <td>普通用户</td>
            </tr>
            <tr>
                <td>状态标记</td>
                <c:if test="${0 == user.flag}">
                    <td align="center">未激活</td>
                </c:if>
                <c:if test="${1 == user.flag}">
                    <td align="center">已激活</td>
                </c:if>
            </tr>
        </c:if>
        <c:if test="${1 == user.role}">
            <tr>
                <td>角色标识</td>
                <td>管理员</td>
            </tr>
        </c:if>

        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>

    </table>
</form>
</body>
</html>
