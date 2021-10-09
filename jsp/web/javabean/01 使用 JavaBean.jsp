<%@ page import="com.hfm.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/21
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>01 使用 JavaBean</title>
</head>
<body>
<%-- 传统使用 JavaBean 的方式--%>
<%
    // 创建 javaBean 对象
    User userOne = new User();
    userOne.setId("001");
    userOne.setName("hfming");
    userOne.setPassword("17111711");
    System.out.println(userOne);

    pageContext.getOut().write(userOne.toString());
%>
<hr/>

<%-- 使用 <jsp:useBean> 标签创建 javaBean 对象--%>
<%-- id 对象名称 --%>
<%-- class 完整的包名 + 类名,注意一定要有无参的构造函数，符合 javaBean 规范--%>
<%-- beanName --%>
<%-- type --%>
<%-- scope --%>
<jsp:useBean id="user" class="com.hfm.pojo.User"></jsp:useBean>

<%-- 使用 <jsp:setProperty> 标签设置 javaBean 对象属性--%>
<%-- name javaBean 对象名称 --%>
<%-- property 属性的名称 --%>
<%-- value 属性的值 --%>
<%-- param 属性参数 --%>
<jsp:setProperty name="user" property="name" value="hfm"></jsp:setProperty>
<jsp:setProperty name="user" property="password" value="17111711"></jsp:setProperty>
<jsp:setProperty name="user" property="id" value="001"></jsp:setProperty>

<%-- 使用 <jsp:getProperty> 获取 javaBean 对象属性--%>
<%-- name javaBean 对象名称 --%>
<%-- property 属性名称 --%>
<jsp:getProperty name="user" property="name"/><br/>
<jsp:getProperty name="user" property="id"/><br/>
<jsp:getProperty name="user" property="password"/><br/>
</body>
</html>
