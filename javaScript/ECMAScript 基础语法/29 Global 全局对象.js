// 全局对象
// URL 编码：数据的传输通过特定的协议，但是不支持中文，因此需要对中文数据进行编码，接收端需要进行解码
var str = "https://www.baidu.com/wd=传智播客";

// 只对中文进行编码
// 编码
var encode1 = encodeURI(str);
document.write(encode1 + "<br/>");

// 解码
var decode1 = decodeURI(encode1);
document.write(decode1 + "<br/>");

// 不仅仅对中文进行编码
// 编码
var encode2 = encodeURIComponent(str);
document.write(encode2 + "<br/>");

// 解码
var decode2 = decodeURIComponent(encode2);
document.write(decode2 + "<br/>");

//  parseInt():将字符串转为数字，逐一判断每一个字符是否是数字，直到不是数字为止，将前边数字部分转为number
var str2 = "153ds12";
document.write(parseInt(str2) + "<br/>");

// isNaN():判断一个值是否是NaN 
// NaN六亲不认，连自己都不认。NaN参与的==比较全部问false
var n = NaN;
document.write(n == NaN);
document.write("<br/>")
document.write(isNaN(n) + "<br/>");

//  eval():将 JavaScript 字符串，并把它作为脚本代码来执行。
var str4 = "document.write(str)";
eval(str4);
document.write("<hr/>");