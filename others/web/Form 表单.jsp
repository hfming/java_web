<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>form 表单</title>
    </head>
    <body>
        <form id="form">
            <input type="text" name="name">
            <input type="password" name="password">
            <input type="button" value="异步提交" id="submit">
        </form>
        <span></span>
    </body>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $("#submit").click(function (){
            $.post(
                "${pageContext.request.contextPath}/form",
                $("#form").serialize(),
                function (data){
                    $("span").html(data);
                },
                "json"
            );
        })
    </script>
</html>
