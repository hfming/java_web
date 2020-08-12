// 刚开始的时候隐藏
$("#big").hide();

// 绑定多个事件
$("img:first").bind("mouseover mouseout mousemove", function(event) {
	if(event.type == "mouseover") {
		$("#big").show();

	} else if(event.type == "mouseout") {
		// 移开则隐藏
		$("#big").hide();
	} else if(event.type == "mousemove") {
		$("#big").offset({
			// 如果靠太近会出现一顿一顿的现象，是因为坐标指到大图片上面了
			left: event.pageX + 10,
			top: event.pageY + 10
		})
	};
});