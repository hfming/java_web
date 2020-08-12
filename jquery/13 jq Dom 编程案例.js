$(function() {
	// 基数
	$("tr:gt(1):odd").css("background-color", "pink");

	//偶数
	$("tr:gt(1):even").css("background-color", "yellow");
})

function changeAll(obj) {
	$(".itemSelect").prop("checked", obj.checked);
}

$(function() {
	// 需求：点击qq表情，将其追加到发言框中
	$("ul img").click(function() {
		$(".word").append($(this).clone());
	});

	//需求：实现下拉列表选择条目左右选择功能
	$("#toRight").click(function() {
		$("#rightName").append($("#leftName > option:selected"))
	})

	$("#toLeft").click(function() {
		$("#leftName").append($("#rightName > option:selected"))
	})
})