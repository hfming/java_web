// 通用属性相关方法
//获取北京节点的name属性值
var bj = $("#bj");
var jsbj = bj.get(0);

// 固有属性使用 prop,自定义属性使用 attr
alert("JQuery: " + bj.attr("name"));
alert("JQuery: " + bj.prop("name"))
alert("js 原生:" + jsbj.getAttribute("name"));

//设置北京节点的name属性的值为 dabeijing
// js 原生使用 setAttribute() 方法，js 方法与 jq 方法不通用
bj.attr("name", "dabeijing");
alert("JQuery: " + bj.attr("name"));
bj.prop("name", "dabeijing");
alert("JQuery: " + bj.prop("name"));

jsbj.setAttribute("name", "js dabeijing");
alert("js 原生:" + jsbj.getAttribute("name"));

//新增北京节点的 discription 属性 属性值是 didu
bj.attr("discription", "didu");
alert("JQuery: " + bj.attr("discription"));
bj.prop("discription", "didu");
alert("JQuery: " + bj.prop("discription"));

jsbj.setAttribute("discription", "didu");
alert("js 原生:" + jsbj.getAttribute("discription"));

//删除北京节点的name属性并检验name属性是否存在
bj.removeAttr("name");
alert("JQuery: " + bj.attr("name"));

jsbj.setAttribute("name", "js dabeijing");
alert("js 原生:" + jsbj.getAttribute("name"));
jsbj.removeAttribute("name");
alert("js 原生:" + jsbj.getAttribute("name"));

//获得hobby的的选中状态
var bt = $("input[type=checkbox]");

alert("JQuery: " + bt.attr("checked"));
alert("JQuery: " + bt.prop("checked"));
alert("js 原生:" + bt.get(0).getAttribute("checked"));