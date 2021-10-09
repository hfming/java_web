// 标准绑定方式
// 绑定单击事件
$("#name").click(function() {
	alert("绑定单击事件");
});

// 绑定提交事件
$("#submit").click(function() {
	alert("绑定提交事件");
});

$("#name").mouseover(function() {
	alert("鼠标经过");
})
// on 绑定事件 off 解绑事件
$("#bt_1").on("click", function() {
	alert("绑定单击事件")
});

$("#bt_2").on("click", function() {
	// off 解绑事件,不传递参数解绑所有事件
	$("#bt_1").off("click");
});

// togger 事件切换 togger(fun1,fun2....) 第一次单击执行事件1，第二次执行事件2
$("#btn").toggle(function() {
	// 1.9版本.toggle() 方法删除，jQuery Migrate（迁移）插件可以恢复此功能。
	$("#myDiv").css("background-color", "green");
}, function() {
	$("#myDiv").css("background-color", "pink");
});