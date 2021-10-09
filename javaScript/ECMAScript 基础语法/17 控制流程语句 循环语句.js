// 1.while 循环语句
var i = 1;
while(i <= 5) {
	document.write("while <br/>");
	i++;
}

// 2.do_while 循环语句
var j = 0;
do {
	document.write("do-while <br/>");
	j++;
} while (j < 5);

// 3.for 循环语句
var result = 0;
for(var i = 1; i <= 100; i++) {
	result += i;
}
document.write("结果为:" + result + "<br/>");

// 4.for in 循环
var arr = [10, 20, 30, 40];
for(var i in arr) {
	document.write(arr[i] + ",");
}
document.write("<hr/>")
