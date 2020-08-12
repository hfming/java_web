// Number对象
var num1 = new Number(20);
var num2 = new Number(20);
// 值相同但不是同一对象
document.write((num1 == num2) + "<br/>");
document.write(num1.valueOf() == num2.valueOf());
document.write("<br/>");

var num = 3.50;
// ceil()： 向上取整。 如果有小数部分的话，直接+1
document.write(Math.ceil(num) + "<br/>");

// floor(): 向下取整。如果有小数部分的话，直接丢失小数部分，保利整数位
document.write(Math.floor(num) + "<br/>");

// round(): 四舍五入取整。满 5 进一
document.write(Math.round(num) + "<br/>");

// random(): 生成一个随机的 0-1 的小数 .包含 0，不包含 1
document.write(Math.round(Math.random() * 100) + "<br/>");

// max(): 返回最大值
document.write(Math.max(10, 6, 54, 23, 76) + "<br/>");

// min(): 返回最小值
document.write(Math.min(10, 6, 54, 23, 76) + "<br/>");
document.write("<hr/>");