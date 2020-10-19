<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>更改购物车内商品相关信息</title>
</head>
<body>

<form action="cart.action?method=updateNumber" method="post">
    <table width="600px" border="1px" align="center">

        <tr>
            <td>用户名</td>
            <td>${cart.id}</td>
        </tr>

        <tr>
            <td>商品名</td>
            <td>${cart.pid}</td>
        </tr>

        <tr>
            <td>原数量为</td>
            <td>${cart.num}</td>
        </tr>

        <tr>
            <td>原总价为</td>
            <td>${cart.money}</td>
        </tr>

        <tr>
            <td>更改数量为</td>
            <td><input type="text"  name="num" id="text1" onkeyup="result();"></td>
        </tr>

        <tr>
            <td>现总价</td>
            <td><input type="text"  name="money" id="text2"></td>
        </tr>
        <input type="hidden" name="id" value="${cart.id}">
        <input type="hidden" name="pid" value="${cart.pid}">

        <tr>
            <td colspan="2"><input type="submit" value="确认"></td>
        </tr>
    </table>
</form>

<script type="text/javascript">
    function result() {
        var number = document.getElementById("text1").value;
        document.getElementById("text2").value = parseFloat(number) * ${cart.money / cart.num} ;
    }
</script>

</body>
</html>