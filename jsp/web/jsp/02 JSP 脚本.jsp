<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.Random" %>
<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/18
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>02 JSP 脚本</title>
</head>

<body>
<!-- JSP 脚本-->
<!-- 原封不动地翻译到 _jspService 方法中执行-->
<%
    Random random = new Random();
    int ran = random.nextInt(100);
    out.write(ran+"<br/>");
%>

<!-- 九九乘法表 -->
<%
    for (int i = 1; i <= 9; i++) {
        for (int j = 1; j <= i; j++) {
            out.write(i + "*" + j + "=" + (i * j) + "&nbsp&nbsp&nbsp&nbsp");
        }
%>
<br>
<%
    }
%>
<br>
<%
    for (int i = 1; i <= 9; i++) {
        for (int j = 1; j <= i; j++) {
            out.print(i + "*" + j + "=" + (i * j) + "\t");
        }
        // 换行失败
        System.out.println();
        // 换行成功
        out.print("<br/>");
    }
%>
</body>

</html>