// 通过方法获取节点数据
//获取输入框的内容
function getName() {
	//1.得到输入框标签对象，在同一个html中id应该具有唯一性
	var userName = document.getElementById("userName");
	var chickName = document.getElementById("chickName");

	// 获取标签属性值
	chickName.innerHTML = userName.value;

	// 2.返回的是标签数组
	var userName = document.getElementsByName("userName")[0];

	chickName.innerHTML += userName.value;

	//3.返回标签对象数组
	var userName = document.getElementsByTagName("input")[0];
	//获取标签对象的 value 属性值
	chickName.innerHTML += userName.value;
}