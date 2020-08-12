var a = 5,
	b = 6;
// 1. 算数运算符
// 加法运算符

// 两个数字
var d1 = 5 + 5;
// 输出 "10"
document.write(d1 + "<br/>");

// 一个数字和一个字符串
var d2 = 5 + "5";
// 输出 "55"
document.write(d2 + "<br/>");

// boolean 型数据 变量是布尔类型的时候，true=1, false=0;
var d3 = true + 4;
document.write(d3 + "<br/>");

// 某个运算符为 NaN ，结果为 NaN
var d4 = NaN + 1;
document.write(d4 + "<br/>");

// 2.减法运算符
var v1 = 12 - 4;
document.write(v1 + "<br/>");

// 3，乘法运算符
document.write(a * b + "<br/>");

// 4.除法
document.write(b / 2 + "<br/>");

// 5.取模
document.write(b % 4 + "<br/>");

// 递增递减运算与 java 相同
// 递增++
var c1 = 1;
document.write(++c1 + "<br/>");
c1++;
document.write(c1 + "<br/>");

// 递减 --
document.write(--c1 + "<br/>");
c1--;
document.write(c1 + "<br/><hr/>");