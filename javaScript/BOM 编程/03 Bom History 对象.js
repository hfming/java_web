// Bom history 对象
function myBack(){
	// 返回上一页
	history.back();
}

function myForward(){
	// 前进到下一页
	history.forward();
}

function myGo(num){
	// 跳转到某页（正整数：前进 负整数：后退） 1 -2
	history.go(num);
}
