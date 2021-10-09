document.write("<hr/>");
// 原生获取对象的方法，可以当作数组使用
var divList = document.getElementsByTagName("div");

for(var i = 0; i < divList.length; i++) {
	divList[i].innerHTML = "aaa";
	document.write(divList[i].innerHTML);
}
document.write("<hr/>");

// 通过 JQuery 获取对象的方法，也可以当作数组使用
var $divList2 = $("div");
// 改变集合内每一项的内容
$divList2.html("bbb");
// 修改无效，Jquery 与 js 原生函数不通用
$divList2.innerHTML = "CCC";

for(var i = 0; i < $divList2.length; i++) {
	document.write($divList2[i].innerHTML);
}
document.write("<hr/>");

// JQuery 与 js 对象相互转换
// js 转 jq
for (var i = 0; i < divList.length; i++) {
	document.write($(divList[i]).html());
}
document.write("<hr/>");

// jq 转 js
var $div_1 = $("#div_1");

// jq 对象当作数组使用
var div_1 = $div_1.get(0);
document.write(div_1.innerHTML);
