// 进制及进制转换
// 十进制
var v1 = 17;
document.write(v1 + "<br>");

// 八进制：八进制中如果数据超过 0~7，默认解析为十进制数据。
var v2 = 0o17;
document.write(v2 + "<br>");

var v3 = 0o16;
document.write(v3 + "<br>");

var v7 = 0b111111;
document.write(v7 + "<br>")

// 不能直接表示二进制数
var v4 = 15;
document.write(v4 + "<br>");

// 可以使用 toString(进制) 方法进行进制转换 
var v5 = v4.toString(2);
document.write(v5 + "<br>");

// 不能直接表示十六进制
var v6 =v4.toString(16);
document.write(v6 + "<br/><hr/>");
