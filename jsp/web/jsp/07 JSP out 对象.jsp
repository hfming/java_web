<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/19
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         buffer="8kb"
         language="java" %>
<html>
<head>
    <title>07 JSP out 对象</title>
</head>
<body>
<%
    // out.write("缓冲区大小"+out.getBufferSize()+"<br/>");
    out.write("123 ");
    // out 对象相当于带缓存的输出流
    // page 指令中的 biffer 属性控制 out 缓冲区大小，默认为 8kb
    // out 默认缓冲区填满了才会写出数据
    // response.getWriter() 不带缓存区，有数据立即写出
    // 因此  response.getWriter() 先写出数据
    response.getWriter().write("abc");
%>
<br/>
<%
    // out.write("缓冲区大小"+out.getBufferSize()+"<br/>");
    // 关闭缓冲区
    //out.close();
    // 手动控制 out 缓冲输出流
    out.write("123 ");
    out.flush();
    response.getWriter().write("abc");
%>
<br/>
<%
    // out.write() 输出整形数据会输出对应的 ascll 码表
    // 应该使用 out.print()方法输出
    out.write(111);
    out.print(111);
%>
</body>
</html>
