<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: blue
  Date: 2019/8/1
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
</head>
<body>
<h1  align="center">修改页面</h1>
<form action="${pageContext.request.contextPath }/ConUpdateServlet" method="post">
    <input type="hidden" name="id" value="${contact.id }">
    <table border="1" align="center" width="300px">
        <tr>
            <td>姓名 <input type="text" name="name" value="${contact.name}"></td>
        </tr>
        <tr><td>
            <input type="radio" name="gender" value="男"  <c:if test="${contact.gender=='男' }">checked="checked"</c:if>  />男
            <input type="radio" name="gender" value="女"  <c:if test="${contact.gender=='女' }">checked="checked"</c:if> />女
            </td>
        </tr>

        <tr>
            <td>电话 <input type="text" name="phone" value="${contact.phone}"></td>
        </tr>
        <tr>
            <td>邮箱<input type="text" name="email" value="${contact.email}"></td>
        </tr>
        <tr>
            <td>地址 <input type="text" name="address" value="${contact.address}"></td>
        </tr>
        <tr> <td> <input type="submit" value="确定修改"></td></tr>
    </table>



</form>


</body>
</html>
