<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/18
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%-- 第一个指令 tablib 指令在学习标签的时候再学习，taglib 主要用于导入标签--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- include 标签可以写在任意位置--%>
<%-- include 用于导入其他页面--%>
<%-- 相当于 html 的 ifream 框架--%>
<%@ include file="02 JSP 脚本.jsp" %>
<html>
<head>
    <title>04 JSP include 指令</title>
</head>
<body>
<%@ include file="00 JSP 入门.jsp" %>
<%
    out.write("04 JSP 指令");
%>

</body>
</html>
