<%--
  Created by IntelliJ IDEA.
  User: Caber
  Date: 2018/12/19
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function() {
            $("#btn").click(function () {
                $.ajax({
                    url:"user/testJson",r5i
                    contentType:"application/json;charset=UTF-8",
                    data:'{"id":"user5","name":"baijuyi","age":23}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        alert(data);
                    }
                });
            });

        });
    </script>
</head>
<body>
<h2>测试</h2>
<form action="" method="post">
    用户id：<input type="text" name="id" ><br/>
    用户name：<input type="text" name="name" ><br/>
    用户age：<input type="text" name="age" ><br/>
    <input type="submit" value=" 保存 "> </form>
</body>

<form action="/admin/userAdd" method="get">
    用户名：<input type="text" name="name">
    用户年龄：<input type="text" name="age">
    用户性别:<input type="radio" name="sex" value="male">Male
    <input type="radio" name="sex" value="female">Female
    <br>
    <input type="submit" value="Submit">
</form>


<button id="btn">发送ajax的请求</button>




</html>
