// 基本选择器
$(function() {
	// 1.id 选择器
	var $oneDiv = $("#one");
	var $b1 = $("#b1");
	$b1.click(function() {
		$oneDiv.css("background-color", "pink");
	});

	// 2.元素选择器/标签选择器
	var $divList = $("div");
	var $b2 = $("#b2");
	$b2.click(function() {
		$divList.css("background-color", "pink");
	});

	// 3.类选择器
	var $minClass = $(".mini");
	var $b3 = $("#b3");
	$b3.click(function() {
		$minClass.css("background-color", "pink");
	});

	// 4.并集选择器
	var $spAll = $("span,#two");
	$("#b4").click(function() {
		$spAll.css("background-color", "pink");
	});
})