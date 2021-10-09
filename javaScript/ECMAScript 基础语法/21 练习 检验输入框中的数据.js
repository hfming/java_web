// 定义一个函数用于显示该月的日期有多少天
function showDayNum(month) {
	if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
		document.writeln(month + "月有31天");
	} else if(month == 4 || month == 6 || month == 9 || month == 11) {
		document.writeln(month + "月有30天");
	} else if(month == 2) {
		document.writeln(month + "月有28或29天");
	} else {
		document.writeln("输入错误！");
	}
}
// check() 函数用于调用 showDayNum 方法，showDayNum 方法要定义在 check方法之前
function check() {
	//document.writeln(parseInt(document.getElementById("month").value));
	showDayNum(parseInt(document.getElementById("month").value));
}
