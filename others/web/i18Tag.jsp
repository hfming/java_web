<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <%-- 加载国际化标签库 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Web 页面文字国际化</title>
</head>

<body>
<%-- 加载资源包 --%>
<fmt:setBundle basename="message"></fmt:setBundle>
<table align="center" border="1px" cellspacing="0px">
    <tr>
        <th><fmt:message key="username"></fmt:message>：</th>
        <td><input type="text" name="username" placeholder="请输入用户名"/></td>
    </tr>
    <tr>
        <th><fmt:message key="password"></fmt:message>：</th>
        <td><input type="password" name="password" placeholder="请输入密码"/></td>
    </tr>
    <tr>
        <td colspan="2" align="center"><input type="submit" value="<fmt:message key='login'></fmt:message>"/></td>
    </tr>
</table>
</body>
</html>