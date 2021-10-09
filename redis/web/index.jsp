<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Redis 案例</title>
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
</head>
<body>
    <select id="province">
        <option>--请选择省份--</option>
    </select>
</body>
<script type="text/javascript">
    $.post(
        "${pageContext.request.contextPath}/province",
        {
            "action": "provincesJson"
        },
        function (data) {
            var select = $("#province");

            // 遍历
            $(data).each(function () {
                // 创建 option
                var option = "<option name='" + this.id + "'>" + this.name + "</option>"

                // 添加到 select 中
                select.append(option);
            });
        },
        "json"
    );
</script>
</html>
