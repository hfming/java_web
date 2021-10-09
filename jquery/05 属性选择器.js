// 属性选择器
$("#b1").click(function() {
	// 有 title 属性的 div 标签
	$("div[title]").css("background-color","pink");
});

$("#b2").click(function() {
	// 有 title 属性并且值等于 test 的 div 标签
	$("div[title = 'test']").css("background-color","pink");
});

$("#b3").click(function() {
	$("div[title != 'test']").css("background-color","pink");
});

$("#b4").click(function() {
	// ^ 表示开始
	$("div[title ^= 'te']").css("background-color","pink");
});

$("#b5").click(function() {
	// $ 表示结束
	$("div[title $='est']").css("background-color","pink");
});

$("#b6").click(function() {
	// * 通配符
	$("div[title *='es']").css("background-color","pink");
});

$("#b7").click(function() {
	// [][] 分隔多个属性
	$("div[id][title *='es']").css("background-color","pink");
});