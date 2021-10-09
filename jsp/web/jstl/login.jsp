<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/20
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<div color="red">
    ${mes}
</div>

<form action="${pageContext.request.contextPath}/login" method="post">
    用户名:<input type="text" name="name"><br/>
    密码:<input type="password" name="password"><br/>
    <input type="submit" value="登录">
</form>
</body>
</html>
