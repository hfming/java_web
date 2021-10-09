<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/9/1
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Web 页面文字国际化</title>
</head>
<body>
<%
    // 获取前端请求的语言环境
    Locale locale = request.getLocale();
    // 根据浏览器语言环境，使用 ResourceBundle 加载不同资源包
    ResourceBundle bundle = ResourceBundle.getBundle("message", locale);

    // 获取资源包中的数据
    String username = bundle.getString("username");
    String password = bundle.getString("password");
    String login = bundle.getString("login");

    // 放入域中
    pageContext.setAttribute("username", username);
    pageContext.setAttribute("password", password);
    pageContext.setAttribute("login", login);
%>
<table align="center" border="1px" cellspacing="0px">
    <tr>
        <th>${username}：</th>
        <td><input type="text" name="username" placeholder="请输入用户名"/></td>
    </tr>
    <tr>
        <th>${password}：</th>
        <td><input type="password" name="password" placeholder="请输入密码"/></td>
    </tr>
    <tr>
        <td colspan="2" align="center"><input type="submit" value="${login}"/></td>
    </tr>
</table>
</body>
</html>
