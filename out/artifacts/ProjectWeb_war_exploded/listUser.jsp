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
    <title>用户列表</title>
</head>
<body>
<table width="800px" border="1px" align="center">
    <tr>
        <th width="40px">用户序号</th>
        <th width="80px">用户昵称</th>
        <th width="80px">密码</th>
        <th width="80px">邮箱</th>
        <th width="40px">性别</th>
        <th width="80px">角色</th>
        <th width="80px">状态标记</th>
        <th width="100px">激活码</th>
        <th width="100px">操作</th>
    </tr>
    <c:if test="${not empty list}">
        <c:forEach items="${list}" var="user">
            <tr>
                <td align="center">${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td align="center">${user.gender}</td>
                <c:if test="${0 == user.role}">
                    <td align="center">普通用户</td>
                    <c:if test="${0 == user.flag}">
                        <td align="center">未激活</td>
                    </c:if>
                    <c:if test="${1 == user.flag}">
                        <td align="center">已激活</td>
                    </c:if>
                </c:if>
                <c:if test="${1 == user.role}">
                    <td align="center">管理员</td>
                    <td></td>
                </c:if>

                <td>${user.code}</td>
                <td align="center">
                    <a href="user.action?method=deleteUser&id=${user.id}">删除</a>
                    <a href="user.action?method=modifyUser&id=${user.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>

</body>
</html>