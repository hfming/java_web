<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用 JSTL 标签实现日期格式化</title>
</head>
<body>
<%-- 创建日期对象 --%>
<jsp:useBean id="time" class="java.util.Date" scope="page"></jsp:useBean>

<%-- 使用日期格式化标签--%>
<%-- dateStyle 日期格式 full medium short --%>
<%-- timeStyle 时间格式--%>
<%-- type 默认只显示日期 time 显示时间 date 显示日期 both 两者都显示 --%>
<fmt:formatDate value="${time}" dateStyle="full" timeStyle="long" type="both"></fmt:formatDate>
</body>
</html>
