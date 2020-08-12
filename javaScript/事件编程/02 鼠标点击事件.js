// 鼠标点击相关事件

// 鼠标单击
function myOncilck() {
	alert("鼠标单击事件");
}

// 鼠标双击
function myOndblclick() {
	alert("鼠标双击事件");
}

// 动态注册
window.onload = function() {
	var userName = document.getElementById("test");
	userName.onfocus = function() {
		alert("动态注册");
	}
}