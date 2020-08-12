// window.alert("提示框函数");
// 加入 <br> 换行
window.document.write("在网页的当前位置处写内容<br>");

// javaScript 数据类型
// 原始数据类型
// 数据类型分类：
// a) number： 无论整数还是小数，都是 number 类型
// b) string: 无论字符还是字符串，都是 string 类型
// c) boolean
// d) object 对象类型

// 定义和赋值变量： var 变量名=值;
// 注意：
// 1)使用var关键词定义变量，var可以省略的，但是不建议省略 var.
// 2)在js中可以重复定义变量，后面定义的变量会覆盖前面的变量。
// 3)js是弱类型语言，使用var来定义任何数据类型
// 4)js中变量的类型是由变量的值决定的，所以只定义不赋值的变量，就是一个未赋值变量（undefined），未赋值的变量不能使用

// 整形与小数型都是 number 数据类型
// 整形
var a = 10;
// 小数型
var b = 3.14;
// NaN not a number 一个不是数字的数字类型
var c = NaN;

// 字符型与字符串型都是 String 型数据
// 字符型
var d = 'c';
// 字符串型
var e = "hello";

// boolean 型 只有 true false
var f = true;
var g = false;

// Null 空占位符
var h = null;

// 引用数据类型
var i = new Object();

// Undefined 未定义。如果一个变量没有给初始化值，则会被默认赋值为undefined
var j;

// 打印输出
window.document.write(a + "<br>");
window.document.write(b + "<br>");
window.document.write(c + "<br>");
window.document.write(d + "<br>");
window.document.write(e + "<br>");
window.document.write(f + "<br>");
window.document.write(g + "<br>");
window.document.write(h + "<br>");
window.document.write(i + "<br>");
window.document.write(j + "<br>");
document.write("<hr/>")

// typeof(变量)： 查看变量的数据类型
document.write("typeof 查看变量的数据类型<br/>")
document.write(typeof(a) + "<br>");
document.write(typeof(b) + "<br>");
document.write(typeof(c) + "<br>");
document.write(typeof(d) + "<br>");
document.write(typeof(e) + "<br>");
document.write(typeof(f) + "<br>");
document.write(typeof(j) + "<br>");
document.write(typeof(h) + "<br>");
document.write(typeof(i) + "<br>");

document.write("<hr>");
// typeof 第二种用法
document.write(typeof a + "<br>");
document.write(typeof b + "<br>");
document.write(typeof c + "<br>");
document.write(typeof d + "<br>");
document.write(typeof e + "<br>");
document.write(typeof f + "<br>");
document.write(typeof g + "<br>");
document.write(typeof h + "<br>");
document.write(typeof i + "<br>");
document.write(typeof j + "<br>");
document.write("<hr>")