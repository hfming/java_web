<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/18
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>03 JSP 声明</title>
</head>
<body>
<!-- JSP 声明-->
<!-- 声明成员变量-->
<%! String name;%>
<!-- 声明成员函数 -->
<%!
    public void printTest() {
        // JSP 声明中只能写 java 语言不能使用 Html 与 JSP 对象
        System.out.println("JSP 声明语句！");
    }
%>
<%--<%-2、声明 staic 静态代码块-%>--%>
<%!
    private static Map<String, Object> map;

    static {
        map = new HashMap<String, Object>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
    }
%>
<%--%3、声明类方法-%>--%>
<%!
    public int abc() {
        return 12;
    }
%>
<!-- 定义的成员变量与成员函数的使用-->
<%
    name = "hfm";
    printTest();
    out.write(name);
%>
<%-- JSP 注释不会写道 _jspServer 中--%>
<!-- HTML 注释会写道 _jspserver 中-->
</body>
</html>
