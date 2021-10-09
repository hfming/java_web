<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录页面</title>
		<style type="text/css">
			div {
				align-content: center;
				text-align: center;
				border: 1px solid black;
				width: 300px;
				margin: 0 auto;
			}
		</style>
	</head>

	<body>
		<div>
			<form action="/session/login" method="post">
				<label for="name">用户名：</label>
				<input type="text" placeholder="请输入用户名" id="name" name="name" />
				<br />
				<label for="password">密码：</label>
				<input type="password" placeholder="请输入密码" id="password" name="password" />
				<br />
				<input type="submit" value="登录" />
				<input type="reset" value="重置" />
			</form>
		</div>
	</body>

</html>