<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>用户登录页面</title>
</head>
<body>
<form action="userLogin.action?method=login" method="post">
    <span>姓名:</span><input type="text" name="username"> <br>
    <span>密码:</span><input type="password" name="password"> <br>
    <input type="submit" value="提交">
    <a href="addUser.jsp">注册新用户</a>
</form>
</body>
</html>