// Java 代码块对代码进行封装 隔离变量的作用域，javaScript 于其不同
{
	var a = 100;
	document.write(a + "</br>");
} 

// 出了代码块还是有作用，JavaScript不会隔离变量作用域
document.write(a + "</br><hr/>");