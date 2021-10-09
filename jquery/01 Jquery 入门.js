var $div1 = $("#div_1");

document.write($div1.innerHTML + "<br/>");
// jquery 使用 html 才能获取内容
document.write($div1.html() + "<br/>");

// 原来的获取方式
var mdiv = document.getElementById("div_1");
document.write(mdiv.innerHTML+ "<br/>");