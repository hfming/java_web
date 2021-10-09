// 获取myinput 的value值
var $myinput = $("#myinput");
// jq 对象转化成 js 对象
var jsMyInput = $myinput.get(0);

// js 原生使用 value,js 与 JQuery 方法不通用
alert("JQuery:" + $myinput.val());
$myinput.val("李四");
alert("js 原生:" + jsMyInput.value);

var $mydiv = $("#mydiv");
var jsdiv = $mydiv.get(0);
// 获取mydiv的标签体内容
alert("JQuery:" + $mydiv.html());
alert("js 原生:" + jsdiv.innerHTML);

// 获取mydiv文本内容
alert("JQuery:" + $mydiv.text());
alert("js 原生:" + jsdiv.innerText);