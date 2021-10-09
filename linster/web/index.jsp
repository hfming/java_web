<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/29
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
Linster 监听器首页<br/>
当前在线人数：${applicationScope.count}<br/>
当前登录人数：${applicationScope.loginCount}<br/>

<table align="center" border="1px" cellspacing="0px">
    <thead>
    <caption>登录用户列表</caption>
    <tr>
        <th>用户名</th>
        <th>密码</th>
        <th>登录时间</th>
        <th>上一次登录时间</th>
        <th>IP</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="oneUser" items="${applicationScope.users}">
        <tr>
            <td>${oneUser.name}</td>
            <td>${oneUser.password}</td>
            <td>${oneUser.liginTime}</td>
            <td>${oneUser.lastLoginTime}</td>
            <td>${oneUser.IP}</td>
            <td><a href="">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
