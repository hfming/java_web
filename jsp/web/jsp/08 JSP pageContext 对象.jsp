<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/19
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>08 JSP pageContext 对象</title>
</head>
<body>
<%
    // 通过 pageContext 对象获取其他八个对象
    HttpSession session1 = pageContext.getSession();
    // 查看是否相等
    System.out.println(session1==session);

    ServletRequest request1 = pageContext.getRequest();
    System.out.println(request1==request);

    ServletResponse response1 = pageContext.getResponse();
    System.out.println(response1==response);
%>
<%
    // pageContext 可以作为域对象使用,但是只能在当前页面使用，不能用在其他页面
    // 保存数据
    pageContext.setAttribute("name", "hfm");

    String name = (String) pageContext.getAttribute("name");
    pageContext.removeAttribute("name");
    System.out.println(name);
%>
<%
    // 将 pageXContext 保存到其他域对象中
    pageContext.setAttribute("name", "pdd");

    // 保存到 Session 域中
    pageContext.setAttribute("message","保存到 session 域中",PageContext.SESSION_SCOPE);
    // 等价于
//    session.setAttribute("session","保存到 session 域中");

    // 1.通过域对象获取域对象保存的数据
    String mess = (String) session.getAttribute("message");
    System.out.println(mess);

    // 保存到 request
    pageContext.setAttribute("message","保存到 request 域中",PageContext.REQUEST_SCOPE);
    // 2.到指定域中获取域对象数据
    String message = (String) pageContext.getAttribute("message", PageContext.REQUEST_SCOPE);
    System.out.println(message);

    // 保存到 servletContext 域中
    pageContext.setAttribute("message","保存到 servletContext 域中",PageContext.APPLICATION_SCOPE);

    // 保存到 Page 域中(仅仅是当前页面)
    pageContext.setAttribute("message","保存到 Page 域中",PageContext.PAGE_SCOPE);
%>
<%
    // findAttribute 默认从 page 域取数据
    String mes =(String) pageContext.findAttribute("message");
    System.out.println(mes);
%>
</body>
</html>
