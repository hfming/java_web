<%@ page import="com.hfm.pojo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="hfming" uri="http://hfming.com/jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/21
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>04 自定义标签案例</title>
</head>
<body>

<hfming:if test="${3>1}">
    自定义 IF 标签添加判断成立<br/>
</hfming:if>

<c:set var="a" value="6"></c:set>
<%-- 自定义多条件判断标签--%>
<hfming:choose>
    <hfming:when test="${a>10}">
        第一个条件成立<br/>
    </hfming:when>
    <hfming:when test="${a<10}">
        第二个条件成立<br/>
    </hfming:when>
    <hfming:otherwise>
        默认条件成立<br/>
    </hfming:otherwise>
</hfming:choose>

<%
    ArrayList<User> users = new ArrayList<User>();
    users.add(new User("001", "hfm", "17111711"));
    users.add(new User("002", "pdd", "3306278"));
    users.add(new User("003", "xtt", "5566798"));
    users.add(new User("004", "xdd", "0808880"));

    // 存储到域对象中
    pageContext.setAttribute("users", users);
%>
<c:forEach var="user" items="${users}" varStatus="vs">
    用户编号:${user.id}<br/>
    用户姓名:${user.name}<br/>
    用户密码:${user.password}<br/>
    编号:${vs.count}<br/>
</c:forEach>
<hr/>

<%-- 自定义 foreach 循环遍历--%>
<hfming:forEach begin="0" end="3" step="1" items="${users}" var="user">
    用户编号:${user.id}<br/>
    用户姓名:${user.name}<br/>
    用户密码:${user.password}<br/>
</hfming:forEach>
<hr/>

</body>
</html>
