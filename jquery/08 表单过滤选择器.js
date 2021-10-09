// 表单过滤选择器
$("#b1").click(function() {
	// 文本输入框可用
	$("input[type='text']:enabled").val("文本输入框可用");
});

$("#b2").click(function() {
	// 文本输入框不可用
	$("input[type='text']:disabled").val("文本输入框不可用");
});

$("#b3").click(function() {
	// 复选框选中
	var len = $("input[type='checkbox']:checked").length;
	alert(len);
});

$("#b4").click(function() {
	// 多选下拉列表下的选项 option 选中
	var len = $("#job > option:checked").length;
	alert(len);
});
