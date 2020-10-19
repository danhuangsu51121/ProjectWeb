<%@ page import="qf.edu.dao.UserDao" %>
<%@ page import="qf.edu.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: 王超玉
  Date: 2020/9/14
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>管理员</title>
    <style>
        #header {
            background-color:black;
            color:white;
            text-align:center;
            padding:5px;
        }
        #nav {
            line-height:30px;
            background-color:#eeeeee;
            height:600px;
            width:70px;
            float:left;
            padding:5px;
        }
        #section {
            width:890px;
            float:left;
            padding:10px;
        }
        #footer {
            background-color:black;
            color:white;
            clear:both;
            text-align:center;
            padding:5px;
        }
    </style>
</head>

<body>
<%

%>

<div id="header">
    <h1>用户系统</h1>
</div>

<div id="nav">
    <div style="height: 40px"><a href="address.action?method=listAddressByUid&uid=${user.id}" target="mainFrame">地址管理</a></div>
    <div style="height: 40px"><a href="cart.action?method=listCartById&id=${user.id}" target="mainFrame">购物车</a></div>
    <div style="height: 40px"><a href="order.action?method=listOrderByUid&uid=${user.id}" target="mainFrame">订单管理</a></div>
    <div style="height: 40px"><a href="user.action?method=modifyUser&id=${user.id}">信息修改</a></div>
    <div style="height: 40px"><a href="index.jsp" target="_blank">前去购物</a></div>
    <div style="height: 40px"><a href="userLogin.action?method=userLogout" target="#">退出登录</a></div>
</div>

<div id="section">
    <div><iframe name="mainFrame" style="width: 100%; height: 600px;"></iframe></div>
</div>

<div id="footer">
    qf.deu.com
</div>

</body>

</html>
