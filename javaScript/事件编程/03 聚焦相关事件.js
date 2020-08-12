// 聚焦相关事件
function myFocus() {
	var comtent = document.getElementById("username");
	comtent.placeholder = "正在聚焦";
}
// 在对象失去输入焦点时触发。
function myBlur() {
	var comtent = document.getElementById("username");
	comtent.placeholder = "取消聚焦";

	//获取用户输入内容
	var userName = comtent.value;
	//检查用户是否存在
	//显示内容到 span
	//获取到 span
	var userNameTip = document.getElementById("userNameTip");
	if(userName == "eric") {
		userNameTip.innerHTML = "用户已经被占用，请更改!".fontcolor("red");
		console.log("用户已经被占用，请更改!".fontcolor("red"));
	} else {
		userNameTip.innerHTML = "恭喜你，该用户可用！".fontcolor("green");
		console.log("恭喜你，该用户可用！".fontcolor("green"));
	}
}