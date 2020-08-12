// 选择相关事件
function mySelect() {
	//获取选中的内容
	var comtent = document.getElementById("select").value;
	var city = document.getElementById("city");
	//每次先清空城市 select 的内容
	city.innerHTML = "";
	if(comtent == "gd") {
		//把一些 option 选项放入到城市的 select 中
		var arr = ["广州", "珠海", "深圳"];
		for(var i = 0; i < arr.length; i++) {
			city.innerHTML += "<option value='" + arr[i] + "'>" + arr[i] + "</option>";
		}
	}
	if(comtent == "gx") {
		//把一些 option 选项放入到城市的 select 中
		var arr = ["柳州", "桂林", "南宁"];
		for(var i = 0; i < arr.length; i++) {
			city.innerHTML += "<option value='" + arr[i] + "'>" + arr[i] + "</option>";
		}
	}
	if(comtent == "hn") {
		//把一些 option 选项放入到城市的 select 中
		var arr = ["长沙", "湘潭", "郴州"];
		for(var i = 0; i < arr.length; i++) {
			city.innerHTML += "<option value='" + arr[i] + "'>" + arr[i] + "</option>";
		}
	}
}