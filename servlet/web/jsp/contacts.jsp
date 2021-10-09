<%@ page import="com.hfm.servlet.demo.entity.Contact" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/19
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>联系人列表</title>
</head>
<body>
<table align="center" border="1px" cellspacing="0px" width="1000px">
    <thead>
    <caption>联系人列表</caption>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>电话</th>
        <th>邮箱</th>
        <th>地址</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <%
        // 获取到域对象
        ArrayList<Contact> contacts = (ArrayList<Contact>) request.getAttribute("contacts");
        for (Contact contact : contacts) {
    %>
    <tr>
        <td><%=contact.getId()%>
        </td>
        <td><%=contact.getName()%>
        </td>
        <td><%=contact.getGender()%>
        </td>
        <td><%=contact.getPhone()%>
        </td>
        <td><%=contact.getEmail()%>
        </td>
        <td><%=contact.getAddress()%>
        </td>
        <td>
            <a href="/servlet/showContact?id=" + <%=contact.getId() %>>【修改】</a>
            <a href="/servlet/delContact?id=" +<%=contact.getId() %> >【删除】</a>
        </td>
    </tr>
    <%
        }
    %>

    </tbody>
    <tfoot>
    <tr>
        <td colspan="7">
            <a href="/servlet/static/html/AddContact.html">【添加联系人】</a>
        </td>
    </tr>
    </tfoot>
</table>
</body>
</html>
