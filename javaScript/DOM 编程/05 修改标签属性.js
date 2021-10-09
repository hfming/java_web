//获取span标签对象
var mySpan = document.getElementById("mySpan");

/*innerText在IE可以，在火狐不行*/
mySpan.innerText = "标签";
// 设置标签内的HTML内容， 在 IE 和火狐可以，可以写出标签
mySpan.innerHTML += "<h1>标题</h1>";

//获取input对象
var userName = document.getElementById("userName");
userName.value = "请输入用户名";

var i = 1;

function changeImg() {
	//得到标签对象
	var img = document.getElementsByTagName("img")[0];
	if(i == 1) {
		img.src = "../Resources/images/off.gif";
		i++;
	} else {
		img.src = "../Resources/images/on.gif";
		i--;
	}
}

// 全部选择
function selectAll() {
	/*var lq = document.getElementsByName("hobit")[0];
	//alert(lq.checked);
	//设置状态
	lq.checked=true;*/
	var hList = document.getElementsByName("hobit");
	for(var i = 0; i < hList.length; i++) {
		hList[i].checked = true;
	}
}