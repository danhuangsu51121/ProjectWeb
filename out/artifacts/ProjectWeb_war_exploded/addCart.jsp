<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>添加商品到购物车</title>
</head>
<body>

<form action="cart.action?method=addCart" method="post">
    <table width="600px" border="1px" align="center">

        <tr>
            <td>商品名</td>
            <td>${name}</td>
        </tr>

        <tr>
            <td>单价</td>
            <td>${price}</td>
        </tr>

        <tr>
            <td>购买数量</td>
            <td><input type="text"  name="num" id="text1" onkeyup="result();"></td>
        </tr>

        <tr>
            <td>总价</td>
            <td><input type="text"  name="money" id="text2"></td>
        </tr>
        <input type="hidden" name="id" value="${uid}">
        <input type="hidden" name="pid" value="${pid}">

        <tr>
            <td colspan="2"><input type="submit" value="添加到购物车"></td>
        </tr>
    </table>
</form>

<script type="text/javascript">
    function result() {
        var number = document.getElementById("text1").value;
        document.getElementById("text2").value = parseFloat(number) * ${price} ;
    }
</script>

</body>
</html>