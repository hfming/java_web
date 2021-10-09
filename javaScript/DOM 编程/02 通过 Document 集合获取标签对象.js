// 所有标签
var list = document.all;

var result = document.getElementById("result");

for(var i = 0; i < list.length; i++) {
	result.innerHTML += list[i].nodeName+"\t";
}

// 表单标签集合
var formList = document.forms;
var form = document.getElementById("form");

for(var i = 0; i < formList.length; i++) {
	form.innerHTML += formList[i].nodeName+"\t";
}

// 图片标签集合
var imgList = document.images;

for(var i = 0; i < imgList.length; i++) {
	document.getElementById("image").innerHTML += imgList[i].nodeName+"\t";
}