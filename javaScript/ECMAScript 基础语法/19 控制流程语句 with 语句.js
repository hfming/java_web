// with 语句  有了With语句，在存取对象属性和方法时就不用重复指定参考对象。
with(document) {
	write("您好 !");
	write("<br>这个文档的标题是 : \"" + title + "\".");
	write("<br>这个文档的 URL 是: " + URL);
	write("<br>现在您不用每次都写出 document 对象的前缀了 !");
}

with(document) {
	// 行数
	for(var i = 1; i <= 5; i++) {
		// 控制星星数
		for(var j = 1; j <= i; j++) {
			write("*&nbsp;");
		}
		write("<br/>");
	}
	write("<hr/>");
	for(var i = 1; i <= 9; i++) {
		for(var j = 1; j <= i; j++) {
			write(i + "*" + j + "=" + (i * j) + "&nbsp;");
		}
		write("<br/>");
	}
}
document.write("<hr>");