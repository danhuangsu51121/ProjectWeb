<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>上架商品信息</title>
</head>
<body>
<form action="good.action?method=addGood" method="post">
    <table width="600px" border="1px" align="center">
        <tr>
            <td>商品名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>

        <tr>
            <td>上架时间</td>
            <td><input type="date" name="pubdate"></td>
        </tr>
        <tr>
            <td>图片</td>
            <td><input type="text" name="picture"></td>
        </tr>

        <tr>
            <td>价格</td>
            <td><input type="text" name="price"></td>
        </tr>

        <tr>
            <td>评分</td>
            <td><input type="text" name="star"></td>
        </tr>

        <tr >
            <td>商品详情</td>
            <td><textarea name="info" cols="50" rows="4"></textarea></td>
        </tr>


        <tr>
            <td>商品类型</td>
            <td><select name="typeid">
                <option value="1">电子用品</option>
                <option value="2">清洁用品</option>
                <option value="3" selected>宠物世界</option>
                <option value="4">美味饮食</option>
                <option value="5">图书专区</option>
            </select></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>