// 正则表达式的创建方式
// \元符号需要进行转义
var reg1 = new RegExp("\\w{3,5}");

// 不能使用引号，不然会认为是字符串
var reg2 = /\w{3,5}/;

var srt= "正则测试";
document.write(reg1.test(str)+"<br/><hr/>");
