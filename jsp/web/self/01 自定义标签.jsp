<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/20
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 1.导入自定义标签库--%>
<%@taglib prefix="hfming" uri="http://hfming.com/jsp" %>
<html>
<head>
    <title>01 自定义标签</title>
</head>
<body>
<%-- 默认获取客户端 ip 地址的方式--%>
<%
    String ip = request.getRemoteHost();
    out.print("当前IP地址:" + ip);
%>
<br/>

<%-- 2.使用自定义标签获取 ip 地址--%>
<%-- 自定义showIp 用来显示 ip 地址--%>
<hfming:showIP></hfming:showIP>

<%-- 自定义标签生命周期 --%>

<hfming:taglife>
    标签生命周期
</hfming:taglife>

 子父标签
<hfming:parent>
    <hfming:taglife>
        标签生命周期
    </hfming:taglife>
</hfming:parent>

</body>
</html>
