<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/19
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         isErrorPage="true"
         language="java" %>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
系统正在恢复，请耐心等候<br>

查看错误信息：
<%-- 出错页面需要使用 ErrorPage 指定错误处理页面--%>
<%-- 错误处理页面必须设置 isErrorPage="true" 声明其是错误处理页面--%>
<%=exception.getMessage()%>
</body>
</html>
