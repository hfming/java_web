<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/20
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <script src="/jsp/js/jquery-3.5.1.min.js" type="application/javascript"></script>
</head>
<body>
<c:choose>
    <c:when test="${empty name}">
        请先<a href="${pageContext.request.contextPath}/jstl/login.jsp" >登录</a>
    </c:when>
    <c:otherwise>
        欢迎回来,您的用户名是${name}
    </c:otherwise>
</c:choose>

<table align="center" border="1px" cellspacing="0px" width="50%">
    <thead>
    <caption>用户列表</caption>
    <tr>
        <th>用户 id</th>
        <th>用户名</th>
        <th>用户密码</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<script type="application/javascript">
    $("tbody > tr:odd").css("background-color", "pink");
    $("tbody > tr:even").css("background-color", "green");
    $("tr:first").css("background-color", "white");
</script>
</html>
