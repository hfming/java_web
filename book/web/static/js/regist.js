// 注册验证
var spTap = $(".errorMsg");

// 校验用户名
function checkName() {
	var username = $("#username").val();
	var reg = /^\w{3,20}$/;
	if(reg.test(username)) {
		return true;
	} else {
		spTap.text("用户名不合法！");
		return false;
	}
}

// 校验密码
function checkPassword() {
	var ps = $("#password").val();
	var reg = /^\w{5,12}$/;
	if(reg.test(ps)) {
		return true;
	} else {
		spTap.text("密码不合法！");
		return false;
	}
}

// 确认密码
function checkRePassword() {
	var ps = $("#password").val();
	var repwd = $("#repwd").val();
	if(repwd.trim() != "" && repwd != null && repwd == ps) {
		return true;
	} else {
		spTap.text("密码再次验证错误！");
		return false;
	}
}

// 校验验证码
function checkVerificationCode() {
	var code = $("#code").val();

	if(code.trim() != "") {
		return true;
	} else {
		spTap.text("验证码输入错误！");
		return false;
	}
}

function checkEmail() {
	// 邮箱验证： xxxxx@xxx.com
	//1 获取邮箱里的内容
	var emailText = $("#email").val();
	//2 创建正则表达式对象
	var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
	//3 使用 test 方法验证是否合法
	if(!emailPatt.test(emailText)) {
		//4 提示用户
		$("span.errorMsg").text(" 邮箱格式不合法！");
		return false;
	} else {
		return true;
	}
}
// 失去焦点就进行校验
$("#username").blur(function() {
	checkName();
});

$("#password").blur(function() {
	checkPassword();
});

$("#repwd").blur(function() {
	checkRePassword();
});

$("#email").blur(function() {
	checkEmail();
});

$("#code").blur(function() {
	checkVerificationCode();
});

// 聚焦时提示信息消除
$("#username").focus(function() {
	spTap.text("");
});

$("#password").focus(function() {
	spTap.text("");
});

$("#repwd").focus(function() {
	spTap.text("");
});

$("#code").focus(function() {
	spTap.text("");
});

$("#email").focus(function() {
	spTap.text("");
});

// 注册案例绑定提交表单事件
$("#sub_btn").click(function() {
	// 全部通过验证才会发生跳转
	if(checkName() && checkPassword() && checkRePassword() && checkVerificationCode() && checkEmail()) {
		spTap.text("");
		return true;
	} else {
		return false;
	}
});

// 点击图片切换验证码
$("#codeImage").click(function() {
	var image = document.getElementById("codeImage");
	// 加时间戳 让其永不取缓存中的数据
	var date = new Date();
	image.src = "/book/checkCode?" + date.getTime();
});

// 点击超链接切换验证码
//$("#aCode").click(function() {
//	var image =  document.getElementById("codeImage");
//	var date = new Date();
//	image.src = "/book/checkCode?" + date.getTime();
//});