<%--
  Created by IntelliJ IDEA.
  User: blue
  Date: 2019/8/1
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加联系人</title>
</head>
<body>
<h2 align="center">添加联系人</h2>
<form method="post" action="${pageContext.request.contextPath }/ContactAdd">

    <table align="center" border="1" width="300px">
        <tr>
            <td>姓名<input type="text" name="name"></td>
        </tr>
        <tr>
<%--            <td>性别<input type="radio" name="gemder" value="男">男--%>

<%--                <input type="radio" name="gender" value="女">女 </td>--%>

    <td>性别
        <input type="radio" name="gender" value="男"/>男
        <input type="radio" name="gender" value="女"/>女
    </td>
        </tr>
        <tr>
            <td>电话<input type="text" name="phone"></td>

        </tr>
        <tr>
            <td>邮箱<input type="text" name="email"></td>

        </tr>

        <tr>
            <td>地址<input type="text" name="address"></td>

        </tr>
        <tr><td align="center"><input type="submit" value="添加"></td></tr>

    </table>

</form>


</body>
</html>
