// 类型运算符
// typeof(变量)： 查看变量的数据类型
document.write("typeof 查看变量的数据类型<br/>")
document.write(typeof(10) + "<br>");
document.write(typeof(10.1) + "<br>");
document.write(typeof(NaN) + "<br>");
document.write(typeof("10") + "<br>");
document.write(typeof("sds") + "<br>");
document.write(typeof(true) + "<br>");
document.write(typeof(false) + "<br>");
document.write(typeof(new Object()) + "<br>");
document.write(typeof(null) + "<br>");
document.write(typeof(z) + "<br>");

document.write("<hr>");
// typeof 第二种用法
document.write(typeof 10 + "<br>");
document.write(typeof 10.1 + "<br>");
document.write(typeof NaN + "<br>");
document.write(typeof "10" + "<br>");
document.write(typeof "sds" + "<br>");
document.write(typeof true + "<br>");
document.write(typeof false + "<br>");
document.write(typeof(new Object()) + "<br>");
document.write(typeof null + "<br>");
document.write(typeof z + "<br>");

document.write("<hr>");
// instanceof 判断是否属于某数据类型与 java 相同
document.write(10 instanceof Number);
document.write("<br><hr/>");