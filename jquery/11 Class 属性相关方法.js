// prop 添加属性
$("#b1").click(function (){
	$("#one").prop("class","second");
});

// addClass 添加属性
$("#b2").click(function (){
	$("#one").addClass("second");
});

// removeClass 删除属性
$("#b3").click(function (){
	$("#one").removeClass("second");
});

// 翻转属性,有则删除，无则添加
$("#b4").click(function (){
	$("#one").toggleClass("one");
});

// 获取颜色
$("#b5").click(function (){
	var color = $("#one").css("background-color");
	alert(color);
});

// 设置颜色
$("#b6").click(function (){
	 $("#one").css("background-color","green");
});