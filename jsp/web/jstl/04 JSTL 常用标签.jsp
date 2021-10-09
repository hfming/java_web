<%@ page import="com.hfm.pojo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/20
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>04 JSTL 常用标签</title>
</head>
<body>
<%-- <c:set> 标签,用于赋值 --%>
<%-- 给域对象赋值 --%>
传统赋值方式:
<%
    String name = "hfm";
    pageContext.setAttribute("name", name);
%>
EL 表达式获取参数值:${name}<br/>
JSP 获取参数值:<%=pageContext.findAttribute("name")%><br/>

<%-- <c:set> 设置域对象的参数--%>
<%-- var 参数名称 --%>
<%-- value 参数值 --%>
<%-- scope 存储的域对象,默认为 page(page,request,session,application) --%>
<c:set var="name" value="pdd" scope="page"></c:set>
EL 表达式获取参数值:${name}<br/>
<hr/>

<%--<c:out value=""/> 获取数据--%>
<%-- value: 代表获取域中的某个名称内容。如果数据在域中，必须使用EL语法去获取 --%>
<%-- default: 默认值。当前需要获取的内容为null，那么使用默认值代替 --%>
<%-- escapeXml: 默认情况下为true，out标签会把输入的内容进行转义。如果不需要转义，则为false既可！ --%>

<%-- 仅仅输出字符串--%>
<c:out value="name"></c:out><br/>
<%-- 如果数据在域中，必须使用EL语法去获取 --%>
<c:out value="${dd}" default="<h3>标题<h3>"></c:out><br/>
<c:out value="${name}" default="<h3>标题<h3>"></c:out><br/>
<%-- 如果不需要转义，则为false既可 --%>
<c:out value="${dd}" default="<h3>标题<h3>" escapeXml="false"></c:out><br/>
<c:out value="${name}" default="<h3>标题<h3>" escapeXml="false"></c:out><br/>
<hr/>

<%-- <c:if test=""/> 单条件判断标签 --%>
<%-- 如果为真则执行条件块内语句--%>
<c:if test="true">
    条件块内语句
</c:if><br/>
<%-- EL 表达式作为条件判断--%>
<c:if test="${name == null}">
    条件块内语句
</c:if><br/>
<hr/>

<%-- <c:choose> 多条件判断--%>
<%-- 必须三个标签一起使用--%>
<c:set var="a" value="6"></c:set>
<c:choose>
    <c:when test="${a>10}">
        a > 10
    </c:when>
    <c:when test="${a<10}">
        a < 10
    </c:when>
    <c:otherwise>
        a = 10
    </c:otherwise>
</c:choose>
<br/>
<hr/>

<%-- <c:forEach> 循环遍历 --%>
<%
    ArrayList<User> list = new ArrayList<>();
    list.add(new User("0001","hfm","181111"));
    list.add(new User("0002","pdd","facker"));
    list.add(new User("0003","ddf","true"));
    list.add(new User("0004","77k","my only love"));
    pageContext.setAttribute("list", list);
%>
EL 表达式:${list}<br/>
<%--begin: 从哪个元素开始遍历，从0开始--%>
<%--end: 到哪个元素位置--%>
<%--step: 增加步长。默认step为 1--%>
<%--items: 需要遍历的数据。（数组|List集合|Map集合） 如果是获取域数据，那么使用EL表达式获取--%>
<%--var: 每个元素名称--%>
<%--varStatus: 当前状态对象。该对象封装当前元素状态信息。例如 count属性: 表示当前遍历的是哪个元素，从1开始 --%>
<c:forEach begin="0" end="3" step="1" items="${list}" var="user" varStatus="varSta" >
    姓名:${user.name}
    密码:${user.password}
    序号:${varSta.count}<br/>
</c:forEach>

<%-- map 集合--%>
<%
    HashMap<String,String> map = new HashMap();
    map.put("name1", "value1");
    map.put("name2", "value2");
    map.put("name3", "value3");
    map.put("name4", "value4");
    map.put("name5", "value5");
    pageContext.setAttribute("map", map);
%>
<c:forEach begin="0" end="3" step="1" items="${map}" var="entry" varStatus="varStatus" >
    序号:${varStatus.count}
    index:${varStatus.index}
    编号:${entry.key}
    姓名:${entry.value}<br/>
</c:forEach>
<hr/>

<%-- <c:forTokens> 遍历字符串--%>
<c:set var="subList" value="java-net-php-python" scope="page"></c:set>
<%-- items: 需要遍历的字符串--%>
<%-- delims: 指定分割符号--%>
<%-- var: 每个内容的名称--%>
<%-- 主要处理 cookie 字符串--%>
<%-- 传统 EL 表达式--%>
<%
    String str = "java-net-php";
    str.split("-");
    str.substring(0,1);
%>

<c:forTokens items="${subList}" delims="-" var="sub">
    ${sub}
</c:forTokens>
<hr/>

<%-- <c:redirect> 重定向 --%>
<%-- 重定向不能传递参数 --%>
<%--<c:redirect url="http://localhost/jsp/jstl/04%20JSTL%20%E5%B8%B8%E7%94%A8%E6%A0%87%E7%AD%BE.jsp" >--%>
<%--</c:redirect>--%>

</body>
</html>
