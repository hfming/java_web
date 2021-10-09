// <input type="button" value="将反恐放置到city的后面"  id="b1"/>
$("#b1").click(function() {
	$("#city").append($("#fk"));
});

// <input type="button" value="将反恐放置到city的最前面"  id="b2"/>
$("#b2").click(function() {
	$("#city").prepend($("#fk"));
});

// <input type="button" value="将反恐插入到天津后面"  id="b3"/>
$("#b3").click(function() {
	$("#tj").after($("#fk"));
});
// <input type="button" value="将反恐插入到天津前面"  id="b4"/>
$("#b4").click(function() {
	$("#tj").before($("#fk"));
});

// <input type="button" value="删除<li id='bj' name='beijing'>北京</li>"  id="b1"/>
$("#b5").click(function() {
	$("#bj").remove();
});

// <input type="button" value="删除city所有的li节点   清空元素中的所有后代节点(不包含属性节点)"  id="b2"/>
$("#b6").click(function() {
	$("#city").empty();
});
