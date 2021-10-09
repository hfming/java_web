<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/19
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>猜数字游戏</title>
</head>
<body>
<span>
      	<font color="red" >${msg}${timesStr}</font>
    	<form action="${pageContext.request.contextPath}/guess" method="post">
    	请输入一个你的幸运数字： <input type="text" name="lucyNo" placeholder="0-30"/><br/>
    		<input type="hidden" name="times" value="${times }"/>
    		<input type="submit" value="开始竞猜"/>
    	</form>
</span>
</body>
</html>
