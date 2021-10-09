var i = 1;
// 改变图片
function changeImage() {
	i++;
	var image = document.getElementById("t_img");
	if(i > 3) {
		i = 1;
	}
	image.src = "../Resources/images/banner_" + i + ".jpg"
}
setInterval("changeImage()", 3000);

// 跳转
function toHead() {
	location.href = "01 Bom window 对象.html";
}

var time = 5;
// 改变时间
function timeChange() {
	var sp = document.getElementById("time");
	sp.innerHTML = time--;
	if(time < 0) {
		toHead();
	}
}

setInterval("timeChange()", 1000);