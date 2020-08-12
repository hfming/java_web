// 变量的使用细节

// 1、var 关键字在定义变量的时候可以省略不写
variable = "没有使用 var 关键字定义的变量";

// 打印输出
document.write(variable + "<br>");

// 2、 变量名可以重复， 后面的将覆盖前面的变量
var visible = true;
visible = "变量名可以重复， 后面的将覆盖前面的变量";
document.write(visible + "<br>");

// 3、 变量的类型取决于值的类型
var color = "red";
var num = 25;

document.write(typeof color + "<br>");
document.write(typeof num + "<br>");

// 4、一条语句定义多个变量。 中间使用逗号隔开即可， 可初始化， 也可以不初始化。
var va = 12,
	vb = "变量2",
	vc = true;
document.write(va + "<br>");
document.write(vb + "<br>");
document.write(vc + "<br><hr>");