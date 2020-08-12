var index = 0;

function addUser() {
	var addTr = document.createElement("tr");
	var td1 = document.createElement("td");
	var td2 = document.createElement("td");
	var td3 = document.createElement("td");

	td1.innerHTML = ++index;
	td2.innerHTML = document.getElementById("userName").value;
	td3.innerHTML = document.getElementById("password").value;
	// 设置属性
	addTr.setAttribute("id", "tr_" + index);

	addTr.appendChild(td1);
	addTr.appendChild(td2);
	addTr.appendChild(td3);

	var target = document.getElementById("set");

	document.getElementsByTagName("tbody")[0].insertBefore(addTr, target);
	
	var userName = document.getElementById("userName");
	var password = document.getElementById("password");
	userName.value = "";
	password.value = "";
}

function removeUser() {
	if(index == 0) {
		return;
	}
	var target = document.getElementById("tr_" + index--);
	var tbody = document.getElementsByTagName("tbody")[0];

	tbody.removeChild(target);
}