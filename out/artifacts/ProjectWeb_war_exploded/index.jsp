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
  <title>欢迎光临菜鸡购物商城</title>
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

<div id="header">
  <h1>主页</h1>
</div>

<div id="nav">
  <div style="height: 40px"><a href="good.action?method=listGoodByTypeid&typeid=1" target="mainFrame">电子用品</a></div>
  <div style="height: 40px"><a href="good.action?method=listGoodByTypeid&typeid=2" target="mainFrame">清洁用品</a></div>
  <div style="height: 40px"><a href="good.action?method=listGoodByTypeid&typeid=3" target="mainFrame">宠物世界</a></div>
  <div style="height: 40px"><a href="good.action?method=listGoodByTypeid&typeid=4" target="mainFrame">美味饮食</a></div>
  <div style="height: 40px"><a href="good.action?method=listGoodByTypeid&typeid=5" target="mainFrame">图书专区</a></div>
  <div style="height: 40px"><a href="userLogin.jsp" target="#">用户登录</a></div>
</div>

<div id="section">
  <div><iframe name="mainFrame" style="width: 100%; height: 600px;"></iframe></div>
</div>

<div id="footer">
  qf.deu.com
</div>

</body>

</html>
