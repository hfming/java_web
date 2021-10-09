<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hfm.pojo.User" %>
<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/19
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <table border="1px" align="center" width="500px" cellspacing="0px">
        <thead>
        <caption>用户列表</caption>
        <tr>
            <td>用户编号</td>
            <td>用户姓名</td>
            <td>用户密码</td>
        </tr>
        </thead>
        <tbody>
        <%
            // 获取到域对象
            ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
            for (User user : users) {
        %>
        <tr>
            <td><%=user.getId()%>
            </td>
            <td><%=user.getName()%>
            </td>
            <td><%=user.getPassword()%>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
        <tfoot>

        </tfoot>
    </table>
</body>
</html>
