$("#left button:eq(0)").click(function() {
	$("select[name='sel02']").append($("select[name='sel01'] > option:selected"));
});

$("#left button:eq(1)").click(function() {
	$("select[name='sel02']").append($("select[name='sel01'] > option"));
});

$("#rigth button:eq(0)").click(function() {
	$("select[name='sel01']").append($("select[name='sel02'] > option:selected"));
});

$("#rigth button:eq(1)").click(function() {
	$("select[name='sel01']").append($("select[name='sel02'] > option"));
});

// 定义超链接删除方法
var delectTr = function() {
	// confirm 是 JavaScript 语言提供的一个确认提示框函数。你给它传什么，它就提示什么
	var tar = $(this).parent().parent();
	var name = tar.find("td:first").text();
	if(confirm("确认删除" + name)) {
		tar.remove();
	}
	// 阻止 超链跳转
	return false;
};

// 超链接单击事件

$("a").click(delectTr);

// 绑定单击事件
$("#addEmpButton").click(function() {
	var name = $("#empName").val();
	var email = $("#email").val();
	var salary = $("#salary").val();
	var num = $("a").length + 1;

	var addEmp = $("<tr>" +
		"<td>" + name + "</td>" +
		"<td>" + email + "</td>" +
		"\<td>" + salary + "</td>" +
		"<td>" +
		"<a href=\"deleteEmp?id=00" + num + "\">Delete</a>" +
		"</td>" +
		"\</tr>");

	$("#employeeTable").append(addEmp);

	// 新添加的 超链接绑定事件 get方法获取的是 Dom 对象需要转化成 jq 对象
	$($("a").get(num - 1)).click(delectTr);
});