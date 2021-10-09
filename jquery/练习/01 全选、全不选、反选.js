$("input[value='全选']").click(function(){
	$(":checkbox").prop("checked",true);
});

$("input[value='全不选']").click(function(){
	$(":checkbox").prop("checked",false);
});

$("input[value='反选']").click(function(){
	$(":checkbox[name='city']").each(function(){
		this.checked = !this.checked;
	})
});

$("input[value='提交']").click(function(){
	$(":checkbox[name='city']:checked").each(function(){
		alert(this.value);
	})
});


$("select").click(function(){
	alert($("select :selected").html());
});
