function add() {
	var body = document.getElementsByTagName("body")[0];

	// 创建按钮
	var input = document.createElement("input");
	// 设置按钮属性
	input.setAttribute("type", "button");
	input.setAttribute("value", "添加按钮");

	// 添加子标签
	body.appendChild(input);

	var inputList = document.getElementsByTagName("input");

	//body.insertBefore(input, inputList[1]);
}

function remove() {
	var body = document.getElementsByTagName("body")[0];

	body.removeChild(body.lastChild);
}