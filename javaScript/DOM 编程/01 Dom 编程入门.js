// Dom 实例
function changeImg() {
	var light = document.getElementById("light");
	var on_off = document.getElementById("on-off");

	var newImg = new Image();
	newImg.src = "../Resources/images/off.gif";

	if(light.src.value === newImg.src.value) {
		light.src = "../Resources/images/on.gif";
		on_off.value = "关灯"
	} else {
		light.src = "../Resources/images/off.gif";
		on_off.value = "开灯"
	}
}