// 比较运算符
// 比较数字
var a = 10;
var b = 20;

document.write(a > b);
document.write("<br/>")
document.write(a < b);
document.write("<br/>")
document.write(a == b);
document.write("<br/>")

// 比较字符串
// 上面这段代码比较的是字符串 "25" 和 "3"。两个字符串在比较的时候比较的是两个字符串对应的字符顺序。
var b1 = "25" < "3";
document.write(b1 + "<br/>"); //true

// 字符串与数字进行比较
// 如果字符串与比较，会把字符串转成数字再进行比较。如果把某个运算数改为数字，那么结果就不一样了
// 字符串"25"将被转换成数字25，然后与数字3进行比较，结果不出所料。无论何时比较一个数字和一个字符串ECMAScript 都会把字符串转换成数字，然后按照数字顺序比较它们。
var b2 = "25" > 3;
document.write(b2 + "<br/>");

// 特殊的比较运算符
// === 等值等型 值相等并且数据类型也相等
var v1 = "2" == 2;
document.write(v1 + "<br/>"); // true
var v2 = "2" === 2;
document.write(v2 + "<br/>"); // false

// !== 不等值或不等型
var v3 = "3" !== 3;
document.write(v3 + "<br/>");

// 三元运算符
// 运算符是 ECMAScript 中功能最多的运算符，它的形式与Java中的相同。variable = boolean_expression ? true_value : false_value;
// 该表达式主要是根据boolean_expression的计算结果有条件地为变量赋值。如果Boolean_expression为true，就把true_value赋给变量；如果它是 false，就把 false_value 赋给变量。
// 例如：var iMax = (iNum1 > iNum2) ? iNum1 : iNum2;
// 在这里例子中，iMax将被赋予数字中的最大值。表达式声明如果iNum1大于iNum2，则把iNum1 赋予iMax。但如果表达式为false（即 iNum2 大于或等于iNum1），则把iNum2赋予iMax。
var c = (a > b) ? a : b;
document.writeln(c+"<hr/>");