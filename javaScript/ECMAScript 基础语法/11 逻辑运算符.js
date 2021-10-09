// 逻辑运算符
var a = true;
var b = false;
// 与运算
document.writeln(a && b);
document.write("<br/>");

// 或运算
document.writeln(a || b);
document.write("<br/>");

// 取反
document.writeln(!b);
document.write("<br/><hr/>");

// 	这段代码在进行逻辑AND运算时将引发错误，因为变量bUnknown是未定义的。变量bTrue的值为true，因为逻辑AND运算将继续计算变 bUnknown。这样做就会引发错误，因为bUnknown的值是undefined，不能用于逻辑AND运算。

var bTrue = true;
// 发生错误
// var bResult = (bTrue && bUnknown);
// 这一行不会执行
// alert(bResult);