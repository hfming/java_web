function mySelect() {
    var sel = document.getElementsByName("province")[0];

    var city = document.getElementsByName("city")[0];

    if (sel.valueOf().value === "河北") {
        var arr = ["柳州", "桂林", "南宁"];
        for (var i = 0; i < arr.length; i++) {
            city.innerHTML += "<option value='" + arr[i] + "'>" + arr[i] + "</option>";
        }
    } else if (sel.valueOf().value === "辽宁") {

    }
}