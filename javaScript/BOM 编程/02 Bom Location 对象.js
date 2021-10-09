// location 对象
// Location 对象是 Window 对象的一个部分，可通过 window.location 属性来访问。

// href 属性： 代表的是地址栏的 URL，可以获取和设置 URL。URL 表示统一资源定位符
// reload方法 
function AutoReload() {
	window.location.reload();
}
// 定时刷新
setInterval("AutoReload()", 5000);

function myHref() {
	alert(location.href);
	// 通过修改href 属性跳转页面，类似于超链接
	location.href = "01 Bom window 对象.html";
}