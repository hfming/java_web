function showImage() {
	$("#ad").show(3000, "swing");
}

function hideImage() {
	$("#ad").hide(3000, "swing");
}

window.onload = function() {
	// 设置定时器
	setInterval("showImage()", 3000);

	setInterval("hideImage()", 8000);
}