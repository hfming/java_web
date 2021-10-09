<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/9/1
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<%-- 表单的 enctype 必须是 multipart/form-data--%>
<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
   选择要上传的文件 <input type="file" name="file"> <br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
