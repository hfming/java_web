// switch
var i = "b";
var b = "b";
switch(i) {
	case "a":
		document.write("你选择了 a");
		break;
	case b:
		document.write("你选择了 b");
		// 如果没有 break 会继续向下执行直到遇到 break
		// break;
	case "c":
		document.write("你选择了 c");
		break;
	case "d":
		document.write("你选择了 d");
		break;
	default:
		document.write("你选择了其他");
		break;
}
document.write("<hr/>");
