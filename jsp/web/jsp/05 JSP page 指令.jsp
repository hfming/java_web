<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/19
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%-- page 指令--%>
<%@ page
        language="java"
        import="java.util.*"
        pageEncoding="utf-8"
        contentType="text/html;charset=UTF-8"
        errorPage="../common/error.jsp"
        isErrorPage="false"
        session="true"
        buffer="8kb"
        isELIgnored="false"
%>
<%-- page 指令可以定义多个 --%>
<%@ page import="java.time.format.DateTimeFormatter" %>
<html>
<head>
    <title>05 JSP page 指令</title>
</head>
<body>
<%
    DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
%>

</body>
</html>
