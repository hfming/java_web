<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page import="java.net.URLDecoder" %>
<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/18
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>当前时间</title>

</head>

<body>
<%
    // 创建日期对象
    LocalDateTime now = LocalDateTime.now();
    // 使用自定义格式
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");
    // 格式化
    String format = dateTimeFormatter.format(now);
    // 中文需要进行编码
    String encode = URLEncoder.encode(format, StandardCharsets.UTF_8);

    Cookie[] cookies = request.getCookies();
    // 如果已经有 cookie 则显示第一次及上一次访问的时间，否则设置第一次访问的时间
    StringBuilder outString = new StringBuilder();
    if (cookies != null) {
        boolean flag = false;
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();

            // 中文需要进行解码
            String decode = URLDecoder.decode(value, StandardCharsets.UTF_8);
            if ("LastTime".equalsIgnoreCase(name)) {
                out.append(name + ":" + decode + "<br/>");
            }
            if ("FirstTime".equalsIgnoreCase(name)) {
                out.append(name + ":" + decode + "<br/>");
                flag = true;
            }
        }
        if (!flag) {
            Cookie firstTime = new Cookie("FirstTime", encode);
            response.addCookie(firstTime);
        }
        response.getWriter().write(outString.toString());

        // 添加本次访问时间
        Cookie lastTime = new Cookie("LastTime", encode);
        response.addCookie(lastTime);
    } else {
        Cookie firstTime = new Cookie("FirstTime", encode);
        Cookie lastTime = new Cookie("LastTime", encode);
        response.addCookie(firstTime);
        response.addCookie(lastTime);
    }
%>
</body>

</html>