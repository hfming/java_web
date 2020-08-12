// String对象
var str1 = new String("hello");
var str2 = new String("hello");
var str = new String("hello|world|33466445");
// 非同一对象
document.write("结果：" + (str1 == str2) + "<br/>"); 

// valueOf（）:该方法返回对象的内容
document.write("结果：" + (str1.valueOf() == str2.valueOf()) + "<br>");

// charAt(): 返回指定索引的内容
document.write(str.charAt(4) + "<br/>");

// indexOf(): 返回首次出现指定字符的索引位置
document.write(str.indexOf("a") + "<br/>");

// lastIndexOf(): 返回最后出现指定字符的索引位置
document.write(str.lastIndexOf("a") + "<br/>");

// fontcolor(): 直接给字符串添加颜色
document.write(str.fontcolor("#0000ff") + "<br/>");

// replace(): 替换指定的字符串
document.write(str.replace("hello", "itcast") + "<br/>");

// substring(start,end); 截取字符串，start：开始索引， end:结束索引
document.write(str.substring(5, 9) + "<br/>");

// substr(strat,[length]) 截取字符串， start：开始索引 length: 截取的字符串长度
document.write(str.substr(5, 4) + "<br>");

// split(): 使用指定字符串切割字符串，返回字符串数组
document.write(str.split("|"));
document.write("<hr/>");