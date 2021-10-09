var images = [
	"Resources/img/man00.jpg",
	"Resources/img/man01.jpg",
	"Resources/img/man02.jpg",
	"Resources/img/man03.jpg",
	"Resources/img/man04.jpg",
	"Resources/img/man05.jpg",
	"Resources/img/man06.jpg"
];

// stop 默认不能点击
$("#stop").attr("disabled", true);
$("#img2").hide();

// 改变图片
var i = 0;

function changeImage() {
	i = Math.floor((Math.random() * images.length)) + 1;
	$("#img1").prop("src", images[i]);
}
// 设置定时器,需要使用引号将方法包起来
$(function() {
	$("#img1").prop("src", images[i]);
});

var imgTask;

$("#start").click(function() {
	imgTask = setInterval("changeImage()", 100);
//	$("#img2").fadeOut("slow", "swing");
	// 不能点击
	$("#start").attr("disabled", true);
	$("#stop").attr("disabled", false);
});

$("#stop").click(function() {
	// 清楚定时器
	clearInterval(imgTask);
	// 设置图片源
	$("#img2").prop("src", images[i]);
	// 设置图片显示方式
	$("#img2").fadeIn("slow", "swing");
	$("#stop").attr("disabled", true);
	$("#start").attr("disabled", false);
});