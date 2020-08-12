var tdiv = $("#showDiv");

// 隐藏
$("#b1").click(function() {
	// 默认动画
	tdiv.hide("fast", "swing");

	// 滑动动画
	tdiv.slideDown(5000, "swing");

	// 淡入淡出
	tdiv.fadeOut(5000, "swing");
})

// 显示
$("#b2").click(function() {
	// 1. speed：动画的速度。三个预定义的值("slow","normal", "fast")或表示动画时长的毫秒数值(如：1000)
	// 2. easing：用来指定切换效果，默认是"swing"，可用参数"linear"
	//		* swing：动画执行时效果是 先慢，中间快，最后又慢
	//		* linear：动画执行时速度是匀速的
	// 3. fn：在动画完成时执行的函数，每个元素执行一次。
	tdiv.show("fast", "swing");

	// 滑动动画
	tdiv.slideUp(5000, "swing");

	// 淡入淡出
	tdiv.fadeIn(5000, "swing");
})

// 切换
$("#b3").click(function() {
	// tdiv.toggle("fast", "swing");
	tdiv.slideToggle(5000, "swing");
	tdiv.fadeToggle(5000, "swing");
})

// 移动
// 默认情况下，所有的 HTML 元素有一个静态的位置，且是不可移动的。
// 如果需要改变为，我们需要将元素的 position 属性设置为 relative, fixed, 或 absolute!
$("#b4").click(function() {
	tdiv.animate({
		// 位移量
		left: '250px',
		// 透明度
		opacity: '0.75',
		height: '150px',
		width: '150px'
	});
})