var sp = document.getElementById("result");

// 定位根节点
var rootNode = document.forms[0];
sp.innerHTML += "rootNode" + rootNode.nodeName + "<br/>";

// 所有子节点集合，获取的子节点包含了以下的元素：a)标签 1；b)空格换行 3；c)html注释 8
var childs = rootNode.childNodes;
for(var i = 0; i < childs.length; i++) {
	sp.innerHTML += childs[i].nodeName + "<br/>";
}

// 第一个子节点
var firstChild = rootNode.firstChild;
sp.innerHTML += "firstChild" + firstChild.nodeName + "<br/>";

// 最后一个子节点
var lastChild = rootNode.lastChild;
sp.innerHTML += "最后一个子节点" + lastChild.nodeName + "<br/>";

// 下一个兄弟节点
var nextSibling = firstChild.nextSibling;
sp.innerHTML += "下一个兄弟节点" + nextSibling.nodeName + "<br/>";

// 上一个兄弟节点
var parSibling = lastChild.previousSibling;
sp.innerHTML += "上一个兄弟节点" + parSibling.nodeName + "<br/>";

// 父节点
var parnetNode = rootNode.parentNode;
sp.innerHTML += "parnetNode" + parnetNode.nodeName + "<br/>";

// 使用 nodeType 筛选子节点
for(var i = 0; i < childs.length; i++) {
	if(childs[i].nodeType == 1) {
		sp.innerHTML += childs[i].nodeName + "<br/>";
	}
}

// 删除节点
rootNode.removeChild(nextSibling);
rootNode.removeChild(parSibling.previousSibling);