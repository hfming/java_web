<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/19
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>01 EL 表达式入门</title>
</head>

<body>
<%-- JSP 脚本--%>
<%
    String name = "hfm";
%>
<%-- JSP 表达式--%>
<%=name%>
<br/>

<%-- EL 表达式--%>
<%-- 不能获取局部变量中的数据--%>
EL 表达式：${name}
<%-- EL表达式作用，向浏览器输出域对象中的变量或表达式计算的结果。变量 name 不是域对象中的变量--%>
<br/>

<%-- 将变量放到 域对象中--%>
<%
    pageContext.setAttribute("name", name);
    pageContext.setAttribute("name2", "name2",PageContext.SESSION_SCOPE);
%>
<%-- 使用 EL 表达式取出域对象中的数据--%>
EL 表达式取出域对象中的值：${name} &nbsp; ${name2}
<br/>
等价于：<%=pageContext.findAttribute("name")%> &nbsp; <%=pageContext.findAttribute("name2")%>
<br/>

<%-- 忽略当前 EL 表达式,原样输出--%>
\${name}
</body>

</html>