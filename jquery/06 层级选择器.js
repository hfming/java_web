// 交集选择器
$("#b1").click(function() {
	$("body div").css("background-color", "pink");
});

// 子选择器
$("#b2").click(function() {
	$("body > div").css("background-color", "pink");
});