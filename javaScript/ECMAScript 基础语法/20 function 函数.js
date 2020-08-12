// function 函数的定义
// 函数的定义方式一：var fun = new Function(形式参数列表,方法体);不建议使用
var fun1 = new Function("va1", "va2", "document.write(va1+va2);");
fun1(4, 5);
document.write("<br/>");

// 函数的定义方式二 
function sayHi(sName, sMessage) {
	document.write("Hello " + sName + sMessage);
};
sayHi("姓名", "信息");
document.write("<br/>");

// 函数的定义方式三
var fun3 = function(userName, password) {
	document.write("用户名：" + userName + "<br/>");
	document.write("密码：" + password + "<br/>");
};

fun3("hfm", "17111711");
document.write(fun3.length + "<br/>");

//  函数使用细节
// 1.js 函数使用 function 定义函数，但是形式参数列表不能使用 var 关键词，返回值类型也不能有 var 关键字
// 2.也可以通过函数名赋值函数， 函数变量的类型是 Function 对象。
// 3.函数的定义优先与执行， 与顺序无关，如果函数在执行时并没有定义则会报错
// 4.js 方法没有重载的概念，后面定义的函数会覆盖前面的函数。当同一个名称的函数定义多次时，最终使用的是最后一个的定义。没有重载！
// 5.js 函数可以有返回值，直接使用 return 关键词返回即可，不需要声明返回值类型 var
// 6.如果函数无明确的返回值，或调用了没有参数的return语句，那么它真正返回的值是 undefined
// 7.js 的形式参数和实际参数的数量可以不一致，依然可以调用。js 函数天然支持可变参数。因此， 函数的参数列表在具体调用的时候实参个数可以和形参个数不同。JS的函数都是类似于Java中可变参数的。
// 8.在JS中，方法的调用只与方法的名称有关，和参数列表无关
// 9.在方法声明中有一个隐藏的内置对象（数组），arguments,这个数组用于接收函数调用时传递过来的实际参数值。arguments 组接收完实际参数后，会逐一的依次从左到右赋值给形式参数，果实际参数数量大于形式参数，则丢失剩下的实际参数。
// 可以通过 arguments 内置对象，获取函数中所有的输入参数
function sum() {
	var sum = 0;
	for(var i = 0; i < arguments.length; i++) {
		sum += arguments[i];
	}
	return sum;
}

var sum = sum(1, 2, 3, 4, 5, 6, 7, 8, 9);
document.write(sum + "<br/><hr/>");