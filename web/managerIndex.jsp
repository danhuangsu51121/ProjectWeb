<%--
  Created by IntelliJ IDEA.
  User: 王超玉
  Date: 2020/9/14
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            width:1200px;
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
<body>

<div id="header">
    <h1>后台管理系统</h1>
</div>

<div id="nav">
    <div style="height: 40px"><a href="user.action?method=listUser" target="mainFrame">用户管理</a></div>
    <div style="height: 40px"><a href="addGood.jsp" target="mainFrame">添加商品</a></div>
    <div style="height: 40px"><a href="good.action?method=listGood" target="mainFrame">商品管理</a></div>
    <div style="height: 40px"><a href="order.action?method=listOrder" target="mainFrame">订单管理</a></div>
    <div style="height: 40px"><a href="userLogin.action?method=userLogout">退出系统</a></div>
    <div style="height: 40px"><a href="" target="mainFrame">待定</a></div>
</div>

<div id="section">
    <div><iframe name="mainFrame" style="width: 100%; height: 600px;"></iframe></div>
</div>

<div id="footer">
    qf.deu.com
</div>

</body>
</body>
</html>
