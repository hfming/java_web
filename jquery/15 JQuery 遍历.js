// js 遍历方式
var jsCitys = document.getElementsByTagName("li");

// 方式一：for 循环
for(var i = 0; i < jsCitys.length; i++) {
	document.write(jsCitys[i].innerHTML);
}

document.write("<br/>");

// 方式二：for in 循环
for(var i in jsCitys) {
	if(jsCitys[i].innerHTML != undefined) {
		document.write(jsCitys[i].innerHTML + " ");
	}
}

document.write("<br/>");
// 数组迭代使用 for in
var arr = [12, 3, 65, 763, 232, 6];
for(var i in arr) {
	document.write(arr[i] + " ");
}
document.write("<br/>");

// jq 遍历方式
var jqCitys = $("#city li");

// 方式一;for 循环
for(var i = 0; i < jqCitys.length; i++) {
	document.write(jqCitys[i].innerHTML + " ");
}

document.write("<br/>");
// 方式二：each(callback)
// 回调函数通过返回值控制循环，返回false 结束循环，返回true 跳过本次循环
jqCitys.each(function() {
	document.write(this.innerHTML + " ");
})
document.write("<br/>");

// 方式三：each(callback(index,element))
jqCitys.each(function(index, element) {
	document.write(index + element.innerHTML + " ");
})
document.write("<br/>");

// 方式四：$.each(object,callback){}
$.each(jqCitys, function() {
	document.write(this.innerHTML + " ")
});
document.write("<br/>");

$.each(jqCitys, function(index, element) {
	document.write(index + element.innerHTML + " ")
});
document.write("<br/>");

// 方式五； for of
for(li of jqCitys) {
	document.write(li.innerHTML + " ");
}