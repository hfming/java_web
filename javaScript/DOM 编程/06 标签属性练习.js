var flag = false;

function getSum() {
	var shopList = document.getElementsByName("shoping");
	var sum = 0;
	for(var i = 0; i < shopList.length; i++) {
		shopList[i].checked = flag;
		if(shopList[i].checked) {
			sum += parseInt(shopList[i].value);
		}
	}
	document.getElementById("allMoney").innerHTML = sum + "元";
}

function changeAll() {
	// 取反
	flag = !flag;
	var allList = document.getElementsByName("all");
	for(var i = 0; i < allList.length; i++) {
		allList[i].checked = flag;
	}
	getSum();
}

function getSum2() {
	var shopList = document.getElementsByName("shoping");
	var sum = 0;
	for(var i = 0; i < shopList.length; i++) {
		if(shopList[i].checked) {
			sum += parseInt(shopList[i].value);
		}
	}
	document.getElementById("allMoney").innerHTML = sum + "元";
}