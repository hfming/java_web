// Date对象
// document.writeln(date+"<br>");
function showTime() {
	// 生成一个系统的当前时间，格式：2015-06-01 15:22:30
	var date = new Date();
	// 当前日期时间的字符串
	var dateStr = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + "&nbsp;" + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
	// 把日期字符串放到 span 中
	// 得到 span 对象
	var dateTip = document.getElementById("dateTip"); //读到了没有加载的标签，无法读取的
	// 设置 span 的 innerHTMl 属性给 span 赋值
	dateTip.innerHTML = dateStr;
}
// 设置定时器，每个多少毫秒调用 1 次任务（函数）
window.setInterval("showTime()", 1000);
document.write("<br/>")

var date = new Date();
// 根据本地时间格式，把 Date 对象的时间部分转换为字符串。
document.write(date.toLocaleDateString() + "<br/>");
// 根据本地时间格式，把 Date 对象转换为字符串。
document.write(date.toLocaleString() + "<br/>");
// 根据本地时间格式，把 Date 对象的日期部分转换为字符串。
document.write(date.toLocaleTimeString() + "<br/>");

// 返回 1970 年 1 月 1 日至今的毫秒数。时间戳
document.write(date.getTime() + "<br/><hr/>");

// function printTime(){
// 	document.write(date.toLocaleString() + "<br/>");
// }
// window.setInterval("printTime()", 1000);
