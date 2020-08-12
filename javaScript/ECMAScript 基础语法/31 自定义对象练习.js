// 设计一个数组工具类
function ArrayUtil() {
	// 二分查找法
	this.search = function(arr, target) {
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
	// 返回最大值
	this.max = function(arr) {
		var max = arr[0];
		for(var i in arr) {
			if(max < i) {
				max = i;
			}
		}
		return max;
	}
}

var arrayUtil = new ArrayUtil();
var arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
var index = arrayUtil.search(arr, 9);
document.write(index + "<br/>");

document.write(arrayUtil.max(arr) + "<br/>");

document.write("<hr/>");