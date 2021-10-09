<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>01 JSP 表达式</title>
	</head>

	<body>
		<!-- JSP 脚本 -->
		<%
    		String name = "hfm";
    		int a = 10;
    		int b = 30;
    	%>
		<!-- JSP 变量 -->
		<%=name%>
		<!-- JSP 表达式-->
		<%=(a+b)%>
	</body>

</html>