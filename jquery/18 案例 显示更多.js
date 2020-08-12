// 默认显示 6 个
$("li:gt(5):not(:last)").hide();

var flag = false;
$(".showmore a").click(function() {
	if(flag) {
		$("li:gt(5):not(:last)").slideUp("slow", "swing");
		$("a span").text("显示全部品牌");

		$("div div").removeClass();
		$("div div").addClass("showmore");
		// 去掉高亮
		$("li:contains('索尼')").removeClass("promoted");
	} else {
		$("li:gt(5):not(:last)").slideDown("slow", "swing");
		$("a span").text("显示部分品牌");
		
		$("div div").removeClass();
		$("div div").addClass("showless");
		// 加高亮
		$("li:contains('索尼')").addClass("promoted");
	}
	flag = !flag;
	return false;
});