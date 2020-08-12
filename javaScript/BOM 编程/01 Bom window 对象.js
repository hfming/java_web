// Bom 编程 window 对象	
// window对象;因为 window 对象使用非常频繁，所以当调用 js 中的 window 对象的方法时，可以省略对象名不写。

// opne()打开新窗口显示指定的 URL（有的浏览器中是打一个新的选项卡）
// 参数一： 打开的页面
// 参数二：打开的方式。 _self: 本窗口 _blank: 新窗口（默认）
// 参数三： 设置窗口参数。比如窗口大小，是否显示任务栏
// 不同的浏览器可能表现的不同
function myOpen() {
	window.open("../../html/00 HTML 基本结构.html", "_blank", "width=300px;height=300px;toobar= no");
}

// 定时器： 每隔 n 毫秒调用指定的任务（函数）;定时执行代码，第一次也是先待，到时再执行
// 参数一：指定的任务（函数）
// 参数二：毫秒数
var taskId;
function intervalOpen() {
	taskId = setInterval("myOpen()", 3000);
}

// clearInterval 清除定时器
function cleanOpen() {
	clearInterval(taskId);
}

// 定时任务 setTimeout
var timeID;
function timeoutOpen() {
	// 超时后执行代码。只执行一次
	timeID = setTimeout(myOpen(), 3000);
}
// 清除定时任务
function cleanTimeoutOpen() {
	window.cleanTimeout(timeID);
}

// 提示框
function myAlter() {
	alert("alter 测试");
}

//选择确定框。
function myConfirm() {
	// 返回值为 true 还是 false
	var flag = confirm("确认框");
	if(flag) {
		alert("正在删除中");
	} else {
		alert("取消删除");
	}
}

// 输入框。
function myPrompt() {
	var input = prompt("输入框");
	if(input == true){
		alert("正在删除");
	}else if(input){
		alert(input);
	}else{
		alert("正在取消");
	}
}