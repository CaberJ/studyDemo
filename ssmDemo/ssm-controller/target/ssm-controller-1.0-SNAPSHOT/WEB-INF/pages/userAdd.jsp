<%--
  Created by IntelliJ IDEA.
  User: Caber
  Date: 2019/2/12
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userAdd</title>
</head>
<body>
<h2>用户添加</h2>
<form action="192.168.1.131/admin/userAdd" method="get">
    用户名：<input type="text" name="name">
    用户年龄：<input type="text" name="age">
    用户性别:<input type="radio" name="sex" value="male">Male
    <input type="radio" name="sex" value="female">Female
    <br>
    <input type="submit" value="Submit">
</form>

<button onclick="location=pages/useradd.jsp">跳转</button>

</body>
</html>
