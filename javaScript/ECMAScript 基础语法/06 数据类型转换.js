// 2. 数据类型转换
var a = "10";
a = "10a";
document.write("a 的类型是(转换前)：" + typeof(a) + "<br/>");
// 转换
a = parseInt(a);
document.write("a 的类型是(转换后)：" + typeof(a) + ", 值为：" + a + "<br/>");

// 字符串"22.5"将被转换成22，因为对于整数来说，小数点是无效字符。
var b = "3.14";
document.write("b 的类型是(转换前)：" + typeof(b) + ", 值为：" + b + "<br/>");
b = parseInt(b);
document.write("b 的类型是(转换后)：" + typeof(b) + ", 值为：" + b + "<br/>");
b = parseFloat(b);
document.write("b 的类型是(转换后)：" + typeof(b) + ", 值为：" + b + "<br/>");

// parseInt() 只会将前面的数字进行转换，如果前面的为字符则转换失败，结果为 NaN。
var c = "a3.14";
document.write("c 的类型是(转换前)：" + typeof(c) + ", 值为：" + c + "<br/>");
c = parseFloat(c);
document.write("c 的类型是(转换后)：" + typeof(c) + ", 值为：" + c + "<br/><hr/>");