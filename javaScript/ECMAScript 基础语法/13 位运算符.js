// 位运算符，与 java 相同
var iNum = 18;
// 输出 "10010"
document.write(iNum.toString(2) + "<br>");

// 取反
document.write(~iNum.toString(2) + "<br>");

var a = 7;
var b = 5;
// 与
document.write((a & b).toString(2) + "<br/>");
// 或
document.write((a | b).toString(2) + "<br/>");
// 异或
document.write((a ^ b).toString(2) + "<br/>");

// 移位运算 111
var c = 7;
document.write(c.toString(2) + "<br/>");
document.write((c << 1).toString(2) + "<br/>");

document.write((c >> 1).toString(2) + "<br/>");
document.write((-c >> 1).toString(2) + "<br/>");

document.write((c >>> 1).toString(2) + "<br/>");
document.write((-c >>> 1).toString(2) + "<br/><hr/>");