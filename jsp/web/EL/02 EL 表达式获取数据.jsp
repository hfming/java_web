<%@ page import="com.hfm.pojo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/19
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>02 EL 表达式获取多种类型数据</title>
</head>
<body>
从 4 个域中存储数据，并取出数据
<br/>

<%--普通字符串--%>
<%
    // 放入域对象中
    pageContext.setAttribute("name", "name");
%>
获取字符串数据：${pageScope.name}
<br/>

<%--普通的对象--%>
<%--${域名称.键名.属性名}本质上会去调用对象的getter方法--%>
<%
    User user = new User("001", "hfm", "password");
    request.setAttribute("user", user);
%>
获取对象数据：${requestScope.user}
<br/>
对象的属性：${requestScope.user.name}
<br/>

<%--数组或List集合--%>
<%--List集合：${域名称.键名[索引]}--%>
<%
    ArrayList<String> list = new ArrayList<>();
    list.add("str1");
    list.add("str2");
    list.add("str3");
    list.add("str4");
    session.setAttribute("list", list);
%>
获取集合数据：${sessionScope.list}
<br/>
集合中的一个对象：${sessionScope.list[0]}
<br/>

<%--Map集合--%>
<%--${域名称.键名.key名称}--%>
<%--${域名称.键名["key名称"]}--%>
<%
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
    application.setAttribute("map", map);
%>
获取map集合数据：${applicationScope.map}<br/>
${map.key1}<br/>
${map["key1"]}<br/>
<br/>

EL 表达式按 page -> request -> session -> servlet 顺序寻找域对象中存储的参数${map}
<br/>
</body>
</html>
