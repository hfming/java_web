<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JQuery 实现 AJAX</title>
		<!-- 导入 Jquery 文件-->
		<script src="js/jquery-3.5.1.min.js" type="application/javascript"></script>
	</head>

	<body>
		<input type="button" value="发送异步请求 $.ajax()" onclick="ajaxTest()" />
		<div id="myDiv1"></div>
		<input type="button" value="发送异步请求 $.get()" onclick="get()" />
		<div id="myDiv2"></div>
		<input type="button" value="发送异步请求 $.post()" onclick="post()" />
		<div id="myDiv3"></div>
		<input type="button" value="发送异步请求 $.getJSON()" onclick="getJson()" />
		<div id="myDiv4"></div>
	</body>
	<!-- $.ajax() 通用 JQuersy 实现 ajax -->
	<script type="application/javascript">
		function ajaxTest() {
			$.ajax({
				// 请求路径
				url: "ajax",
				// 请求方式 POST 或 GET
				type: "POST",
				// 请求参数,可以使用拼串或者 JSON 格式，推荐使用 JSON格式
				//date:"username=jack&age=23",
				data: {
					"username": "jack",
					"age": 23
				},
				// 响应成功后的回调函数
				success: function(date) {
					document.getElementById("myDiv1").innerHTML = date;
				},
				// 如果请求出错的回调函数
				error: function() {
					window.location.href = "index.jsp";
				},
				// 接收到的响应数据的格式,可以设置为 JSON 格式
				dataType: "text"
			})
		}
	</script>
	<!-- $.get() -->
	<script type="application/javascript">
		function get() {
			$.get(
				"ajax", // URL 请求地址,必须有请求地址
				{
					"username": "hfm",
					"age": 26
				}, // 请求参数
				function(date) {
					document.getElementById("myDiv2").innerHTML = date;
				}, // 请求成功回调函数
				"text" //返回内容格式
			)
		}
	</script>
	<!-- $.post() -->
	<script type="application/javascript">
        function post() {
            $.post(
                "ajax", // URL 请求地址,必须有请求地址
                {
                    "username": "hfm",
                    "age": 26
                }, // 请求参数
                function(date) {
                    document.getElementById("myDiv3").innerHTML = date;
                }, // 请求成功回调函数
                "text" //返回内容格式
            )
        }
	</script>
	<!-- $.getJSON() -->
	<script type="application/javascript" >
		function getJson() {
			$.getJSON(
			    // 请求地址
				"ajax",
                // 请求参数
                {
                    "username":"hfm",
                    "age":26
                },
                // 请求成功回调函数
                function (date) {
				    // 使用 getJSON 返回的是一个 JSON 对象
                    document.getElementById("myDiv4").innerHTML = date;
                }
            );
		}
	</script>
</html>