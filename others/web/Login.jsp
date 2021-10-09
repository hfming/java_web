<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>校验用户名是否存在</title>
		<script src="js/jquery-3.5.1.min.js" type="application/javascript"></script>
	</head>

	<body>
		<form>
			<input type="text" name="username" placeholder="请输入用户名" id="username" />
			<span id="username_message"></span>
			<br/>
			<input type="password" name="password" placeholder="请输入密码" /><br/>
			<input type="submit" value="注册" />
		</form>
	</body>
	<script>
		// 绑定离焦事件
		$("#username").blur(function() {
			var userName = $("#username").val();
			// get 方式提交 AJAX 
			$.get(
				"checkName", {
					"username": userName
				},
				function(data) {
					var span = $("#username_message");
					span.html(data.message);
					// 用户名已经存在
					if(data.userExsit) {
						// 如果存在则为红色
						span.css("background-color", "red");
					} else {
						// 不存在则为绿色
						span.css("background-color", "green");
					}
				},
				"json" // 返回内容格式
			);
		});
	</script>

</html>