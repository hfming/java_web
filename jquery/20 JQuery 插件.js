// 1.定义JQuery 对象插件
// 对 jq 对象的功能进行扩展
$.fn.extend({
	// 定义了一个check 方法，所有jq 对象都可以使用该方法
	myFun: function() {
		alert("测试");
	},
	// 使用 逗号分隔函数
	// 复选框选中
	checkboxSelect: function() {
		this.prop("checked", true);
	},
	// 复选框不选中
	checkboxUnselect: function() {
		this.prop("checked", false);
	}
});

// 调用函数
$("#btn-check").click(function() {
	$("input[type='checkbox']").checkboxSelect();
});

$("#btn-uncheck").click(function() {
	$("input[type='checkbox']").checkboxUnselect();
});

// 2.对 JQuery 进行扩展
$.extend({
	max: function(i, j) {
		return(i > j) ? i : j;
	},
	min: function(i, j) {
		return(i > j) ? j : i;
	}
});

document.write("<br/>")
// 调用全局函数
document.write($.max(10, 5) + "<br/>");
document.write($.min(10, 5) + "<br/>");