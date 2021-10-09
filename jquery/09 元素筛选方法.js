// 过滤选择器
$("#b1").click(function() {
	// 第一个元素
	$("div").first().css("background-color", "pink");
});

$("#b2").click(function() {
	// 最后一个
	$("div").last().css("background-color", "pink");
});

$("#b3").click(function() {
	// class 属性不为指定值
	$("div").not(".one").css("background-color", "pink");
});

$("#b6").click(function() {
	// 大于指定索引
	$("div").gt(3).css("background-color", "pink");
});

$("#b7").click(function() {
	// 指定索引
	$("div").eq(3).css("background-color", "pink");
});

$("#b8").click(function() {
	// 小于指定索引
	$("div").lt(3).css("background-color", "pink");
});

$("#b9").click(function() {
	// 标题选择器
	$(":header").css("background-color", "pink");
});