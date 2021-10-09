// 1. 数组的创建方式
// 第一种方式 使用构造函数创建 Array 对象
var arr = new Array(1, 2, 3, 4,true);
document.write(arr + "<br/>");

var arr = new Array(7);
document.write(arr + "<br/>");

// 第二种方式，指定元素创建数组
var arr = [1, 2, 3, 4];
document.write(arr + "<br/>");

// 2.数组元素初始化
// 数组长度可变的，会自动进行扩容
// 数组元素的类型可变的，扩容出的数组元素默认为 unDifinde
var arr2 = new Array(1, 2, 3, 4);
document.write(arr2 + "<br/>");

arr2[10] = 12;
document.write(arr2 + "<br/>");
document.write(arr2[4] + "<br/>");

// 3.数组遍历
for(var i = 0; i < arr.length; i++) {
	document.writeln(arr[i]);
}
document.write("<br/>");

// for in 遍历类似于 java 中的for-each 遍历
for(var i in arr2) {
	document.writeln(arr2[i]);
}
document.write("<br/>");

// 3.数组常用方法
var arr4 = [10, "java", false];

//length 属性： 表示数组的长度
document.writeln(arr4.length + "<br>");

//join(字符串): 使用指定的字符串，把数组的所有元素连接在一起，最终组成一个新的字符串
document.writeln(arr4.join("-") + "<br>");

//reverse(): 反转数组中的元素
arr4.reverse();
for(var i = 0; i < arr4.length; i++) {
	document.write(arr4[i] + ",");
}
document.write("<br/><hr/>");