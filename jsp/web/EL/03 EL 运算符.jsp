<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/19
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>03 EL 运算符</title>
</head>
<body>

<%
    int a = 10;
    int b = 20;
    pageContext.setAttribute("a", a);
    pageContext.setAttribute("b", b);
%>
算术表达式：<br>
${a+b}<br/>
${a-b}<br/>
${a*b}<br/>
${a/b}<br/>
${a div b}<br/>
${a%b}<br/>
${a mod b}<br/>

比较表达式：<br>
${a>b}<br>
${a>=b}<br>
${a<b}<br>
${a<=b}<br>
${a==b}<br>
${a!=b}<br>

逻辑表达式:<br>
<!-- 只能使用双&&及||符号不能使用单&及|符号 -->
<%-- javaScript 也只能使用 && || --%>
${true&&true}<br>
${true&&false}<br>
${false&&false}<br>
${true||true}<br>
${false||true}<br>
${false||true}<br>
${false and false}<br>
${false or false}<br>

判空表达式:<br>
${a==null}<br>
${a==""}<br>
${a==""||a==null}<br>
等价于:${empty a}<br>

<%
    // 1、值为 nul 值的时候，为空
    request.setAttribute("emptyNul", null);
    // 2、值为空串的时候，为空
    request.setAttribute("emptyStr", "");
    // 3、值是 Object 类型数组，长度为零的时候
    request.setAttribute("emptyAr", new Object[]{});
    // 4、list 集合，元素个数为零
    List<String> list = new ArrayList<>();
    // list.ad("abc");
    request.setAttribute("emptyList", list);
    // 5、map 集合，元素个数为零
    Map<String, Object> map = new HashMap<String, Object>();
    // map.ut("key1", "value1");
    request.setAttribute("emptyMap", map);
%>

${ empty emptyNul } <br/>
${ empty emptyStr } <br/>
${ empty emptyAr } <br/>
${ empty emptyList } <br/>
${ empty emptyMap } <br/>

<%--.点运算，可以输出 Bean 对象中某个属性的值。--%>
<%--[]中括号运算，可以输出有序集合中某个元素的值。 并且[]中括号运算，还可以输出 map 集合中 key 里含有特殊字符的 key 的值。--%>
<%
    Map<String, Object> map2 = new HashMap<String, Object>();
    map2.put("a.a", "aValue");
    map2.put("b+b", "bValue");
    map2.put("c-c", "cValue");
    map2.put("d", "dValue");
    request.setAttribute("map2", map2);

    pageContext.setAttribute("a", 10);
    pageContext.setAttribute("b", 20);
    pageContext.setAttribute("c", 30);
    pageContext.setAttribute("d", 40);
%>
<%-- 单引号与双引号都可以--%>
${ map2['a.a'] } <br>
${ map2["b+b"] } <br>
${ map2['c-c'] } <br>
<%-- 不能使用引号将键括起来--%>
<%-- 键中有特殊符号就无法获取正确的值 --%>
${ map2.a.a } <br> <!-- null -->
${ map2.b+b } <br> <!-- null + 20 -->
${ map2.c-c } <br> <!-- null - 30-->
${ map2.d } <br> <!-- dvalue -->
</body>
</html>
