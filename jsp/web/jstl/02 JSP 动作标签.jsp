<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/20
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>02 JSP 动作标签</title>
</head>
<body>
<%
    // 传统转发方式
    // request.getRequestDispatcher("01%20JSTL%20入门.jsp").forward(request,response);
%>

<%-- JSP 标签最重要的一点,标签范围内不能有注释--%>

<%-- 转发标签--%>
<%--<jsp:forward page="01%20JSTL%20入门.jsp">--%>
<%--    <jsp:param value='hfm' name='name'/>--%>
<%--</jsp:forward>--%>
<%-- 参数标签必须在转发标签内部,用于转发时传递参数--%>

<%-- 静态包含--%>
<%@include file="common.jsp"%>
<hr/>

<%-- 动态包含 --%>
<%-- 动态包含底层代码使用如下代码去调用被包含的 jsp 页面执行输出。JspRuntimeLibray.include(request, response, "/include/foter.jsp", out, false);--%>
<jsp:include page="common.jsp">
    <jsp:param name="name" value="hfm"/>
    <jsp:param name="password" value="17111711"/>
</jsp:include>
</body>
</html>
