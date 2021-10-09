// 1.事件绑定
// window.onload 只能定义一次,如果定义多次，后边的会将前边的覆盖掉
window.onload = function() {
	// 传统动态单击事件绑定
	document.getElementById("but_1").onclick = function() {
		alert("动态绑定单击事件！");
	};
}

// 静态绑定方式
function funClick() {
	alert("静态绑定单击事件！");
}

// 2.入口函数，文件加载后执行
// $(function)可以定义多次的。
$(function() {
	// jq 事件绑定
	var $but_1 = $("#but_1");

	$but_1.click(function() {
		alert("JQ 单击事件！");
	});
});

// 3.样式控制
$(function(){
	var $but_1 = $("#but_1");
	
	// 两种方式：推荐第一种
	$but_1.css("background-color","red");
	$but_1.css("backgroundColor","pink");
})
