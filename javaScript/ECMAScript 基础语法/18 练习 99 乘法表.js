// 99 乘法表
document.write("<table border='1px' cellspacing='0px' align='center'>")
for(var i = 0; i < 10; i++) {
	document.write("<tr>");
	for(var j = 1; j <= i; j++) {
		document.write("<td>");
		document.writeln(i + "*" + j + "=" + (i * j) + "&nbsp;&nbsp;&nbsp;");
		document.write("</td>");
	}
	document.write("</tr>");
}
document.write("</table><hr/>");