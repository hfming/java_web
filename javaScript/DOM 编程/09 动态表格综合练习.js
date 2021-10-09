// 添加用户
function addUser() {
	var tr = document.createElement("tr");
	var td0 = document.createElement("td");
	var td1 = document.createElement("td");
	var td2 = document.createElement("td");
	var td3 = document.createElement("td");
	var td4 = document.createElement("td");
	var td5 = document.createElement("td");
	var td6 = document.createElement("td");

	tr.appendChild(td0);
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);
	tr.appendChild(td5);
	tr.appendChild(td6);

	td1.innerHTML = document.getElementById("number").value;
	td2.innerHTML = document.getElementById("userName").value;
	td3.innerHTML = document.getElementById("password").value;
	td4.innerHTML = document.getElementById("age").value;
	td5.innerHTML = document.getElementById("address").value;
	td6.innerHTML = "<span onclick='removeUser(this)'>删除</span>"

	var input = document.createElement("input");
	input.setAttribute("type", "checkbox");
	input.setAttribute("name", "item");
	td0.appendChild(input);

	tr.setAttribute("id", "tr_" + document.getElementById("number").value)

	var body = document.getElementsByTagName("tbody")[0];
	body.appendChild(tr);
}
// 删除所有用户
function removeAll() {
	var body = document.getElementsByTagName("tbody")[0];
	var inputList = document.getElementsByName("item");
	// 删除后会自动移位
	for(var i = 0; i < inputList.length; i++) {
		if(inputList[i].checked) {
			body.removeChild(inputList[i].parentNode.parentNode);
			// 选中时下标移回原位
			i--;
		}
	}
}
// 删除用户
function removeUser(a) {
	var target = a.parentNode.parentNode;
	var body = document.getElementsByTagName("tbody")[0];
	body.removeChild(target);
}
var flag = false;
// 选择所有
function selectAll() {
	// 取反
	flag = !flag;
	var inputList = document.getElementsByName("item");
	for(var i = 0; i < inputList.length; i++) {
		inputList[i].checked = flag;
	}
}
// 正则校验用户名
function checkName() {
	var userName = document.getElementById("userName").value;
	//使用正则校验
	var reg = /^[a-zA-Z0-9]{4,14}$/;
	var nameTip = document.getElementById("nameTip");
	if(reg.test(userName)) {
		//成功 
		nameTip.innerHTML = "用户名正确".fontcolor("green");
		return true;
	} else {
		//失败 
		nameTip.innerHTML = "用户格式有误".fontcolor("red");
		return false;
	}
}

function checkPwd() {
	var userPwd = document.getElementById("password").value;
	//使用正则校验
	var reg = /^[a-zA-Z0-9]{6,16}$/;
	var pwdTip = document.getElementById("pwdTip");
	if(reg.test(userPwd)) {
		//成功 
		pwdTip.innerHTML = "密码正确".fontcolor("green");
		return true;
	} else {
		//失败 
		pwdTip.innerHTML = "密码有误".fontcolor("red");
		return false;
	}
}

function checkRePwd() {
	var userPwd = document.getElementById("password").value;
	var repwd = document.getElementById("repwd").value;
	var repwdTip = document.getElementById("repwdTip");
	if(userPwd == repwd) {
		repwdTip.innerHTML = "两次输入正确".fontcolor("green");
		return true;
	} else {
		repwdTip.innerHTML = "两次输入密码不一致".fontcolor("red");
		return false;
	}
}

function checkEmail() {
	var email = document.getElementById("email").value;
	//使用正则校验（： 字母或数字@字母或数字.(com/cn/net/com.cn) ）
	var reg = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z]{2,3}){1,2}$/;
	var emailTip = document.getElementById("emailTip");
	if(reg.test(email)) {
		//成功
		emailTip.innerHTML = "邮箱正确".fontcolor("green");
		return true;
	} else {
		//失败
		emailTip.innerHTML = "邮箱格式有误".fontcolor("red");
		return false;
	}
}

//校验全部表单选项
function checkAll() {
	if(checkName() && checkPwd()) {
		//全部校验都通过了
		return true;
	} else {
		//只有有一个校验失败了
		return false;
	}
}

var n1 = new Node();
var e1 = new Element();
