<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- url: 表示需要导入的标签库的 url 名称
    每个标签库都会有一个 tld 后缀名的标签声明文件
    在 tld 文件中都有唯一的 url 名称
    这个 url 名称就是当前标签库的名称
--%>
<%--
    prefix: 使用标签库的前缀,通常与 tld 文件的 short-name 名称相同
--%>
CORE 标签库<br/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
XML 标签库<br/>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
FMT 标签库<br/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
SQL 标签库<br/>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
FUNCTIONS 标签库<br/>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>03 JSTL 使用步骤</title>
</head>
<body>
<%-- 保存数据,默认保存到 page --%>
<c:set var="password" value="17111711"></c:set>

<%-- 取出数据,默认取出顺序 page -> request -> session -> servletContext --%>
<c:out value="${password}"></c:out>
</body>
</html>
