// Boolean 对象
var b1 = new Boolean(true);
var b2 = new Number(true);
// 值相同但不是同一对象
document.write((b1 == b2) + "<br/>");
document.write(b1.valueOf() == b2.valueOf());
document.write("<br/>");

// toString 方法转化成字符串
document.write(b1.toString() + "<br/>");

// valueOf() 存储的值
document.write(b1.valueOf() + "<br/>");

document.write("<hr/>");