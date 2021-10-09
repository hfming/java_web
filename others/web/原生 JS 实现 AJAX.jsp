<%--
  Created by IntelliJ IDEA.
  User: hfm
  Date: 2020/8/31
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

	<head>
		<title>AJAX 基础</title>
	</head>

	<body>
		<input type="button" value="发送异步请求" onclick="ajaxTest()" />
		<div id="myDiv">
			
		</div>
	</body>
	<script type="application/javascript">
		// 发送异步请求
		function ajaxTest() {
			// 1.创建核心对象
			var xmlhttp;
			// code for IE7+, Firefox, Chrome, Opera, Safari
			if(window.XMLHttpRequest) {
				xmlhttp = new XMLHttpRequest();
			} else {
				// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}

			// 2. 建立连接
			// 1.请求方式：GET、POST
			// get方式，请求参数在URL后边拼接。send方法为空参
			// post方式，请求参数在send方法中定义  xmlhttp.send("username=tom");
			// 2. 请求的URL：
			// 3. 同步或异步请求：true（异步）或 false（同步）
			xmlhttp.open("GET", "ajax?username=tom", true);

			//3.发送请求
			xmlhttp.send();

			// 4.接受并处理来自服务器的响应结果
			// 获取方式 ：xmlhttp.responseText
			// 什么时候获取？当服务器响应成功后再获取
			// 当xmlhttp对象的就绪状态改变时，触发事件onreadystatechange。
			xmlhttp.onreadystatechange = function() {
				// 判断readyState就绪状态是否为4，判断status响应状态码是否为200
				if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					// 获取服务器的响应结果
					var responseText = xmlhttp.responseText;
					document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
				}
			}
		}
	</script>

</html>