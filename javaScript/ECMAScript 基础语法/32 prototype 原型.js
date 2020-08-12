// prototype 原型方式
String.prototype.trim = function() {
	var start, end;
	start = 0;
	end = this.length - 1;
	while(start <= end && this.charAt(start) == " ")
		start++;
	while(start <= end && this.charAt(end) == ' ')
		end--;
	return this.substring(start, end + 1);
}

var str = "   sasd  百变  ";
var newString = str.trim();
document.write(newString + "<br/>");

// 给 Array 添加一个查找方法
Array.prototype.search = function(target) {
	var min = 0;
	var max = arr.length;
	var mid = parseInt((min + max) / 2);
	while(min < max) {
		if(arr[mid] == target) {
			return mid;
		} else if(arr[mid] > target) {
			max = mid;
		} else {
			min = mid;
		}
		mid = parseInt((min + max) / 2);
	}
	return -1;
}

var arr = [1, 2, 3, 4, 5, 6, 7, 8, 9];
document.write(arr.search(8) + "<br/>");