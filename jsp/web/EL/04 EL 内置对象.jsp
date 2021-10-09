<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/19
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>04 EL 内置对象</title>
</head>
<body>
<!-- pageContext 获取域对象 -->
<%-- pageContext 最主要的作用用于获取 web 上下文路径--%>
${pageContext.request.contextPath}

<!-- pageScope 获取域对象数据 -->
<br> ${pageScope}

<!-- requestScope 获取域对象数据 -->
<br> ${requestScope}

<!-- sessionScope 获取域对象数据 -->
<br> ${sessionScope}

<!-- applicatinoScope 获取域对象数据 -->
<br> ${applicatinoScope}
<%-- jsp 表达式--%>
<%
    // 它可以获取请求的协议
    request.getScheme();
    // 获取请求的服务器 ip 或域名
    request.getServerName();
    // 获取请求的服务器端口号
    request.getServerPort();
    // 获取当前工程路径
    pageContext.getServletContext().getContextPath();
    // 获取请求的方式（GET 或 POST）
    request.getMethod();
    // 获取客户端的 ip 地址
    request.getRemoteHost();
    // 获取会话的唯一标识
    session.getId();
%>

<%
    pageContext.setAttribute("req", request);
%>
1.协议： ${ req.scheme }<br>
2.服务器 ip：${ pageContext.request.serverName }<br>
3.服务器端口：${ pageContext.request.serverPort }<br>
4.获取工程路径：${ pageContext.request.contextPath }<br>
5.获取请求方法：${ pageContext.request.method }<br>
6.获取客户端 ip 地址：${ pageContext.request.remoteHost }<br>
7.获取会话的 id 编号：${ pageContext.session.id }<br>

<!-- 获取表单参数值 -->
<br> ${param['name']}
<br> 传统获取参数的方式:<%=request.getParameter("name")%>

<!-- 获取多选参数值 -->
<br> ${paramValues['name'][0]}
<%--<br> 传统获取参数的方式:<%=request.getParameterValues("name")[0]%>--%>

<!-- 获取请求头 -->
<br> ${header['host']}
<br> 传统获取参数的方式:<%=request.getHeader("host")%><br/>
输出请求头【User-Agent】的值：${ header['User-Agent'] } <br>
输出请求头【Conection】的值：${ header.Conection } <br>
输出请求头【User-Agent】的值：${ headerValues['User-Agent'][0] } <br>

<!-- 获取所有请求头 -->
<br> ${headerValues["host"][0]}
<br> 传统获取参数的方式:<%=request.getHeaders("host")%>

<!-- 获取指定cookie -->
<br> ${cookie['JSESSIONID'].value}
<br> ${cookie['JSESSIONID'].name}

<!-- 获取所有cookie -->
<br> ${cookie}

<!-- 获取全局初始化参数 -->
<br> ${initParam}
<br> 传统方式获取全局参数:<%=application.getInitParameter("username")%>
<br/>
输出&lt;Context-parm&gt;username 的值：${initParam.username} <br>
输出&lt;Context-parm&gt;url 的值：${initParam.url} <br>

</body>
</html>
