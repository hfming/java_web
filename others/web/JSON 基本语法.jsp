<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

	<head>
		<title>JSON 基本语法</title>
	</head>
	<!-- JSON 对象的定义格式-->
	<script type="application/javascript">
		// 1.定义 JSON 基本格式,格式要统一
		// var person = {'name':"张三",age:23,'gender':true};
		// 定义一个对象
		var person = {
			name: "张三",
			age: 23,
			gender: true
		};
		document.write(person + "<br/>");
		document.write(typeof person + "<br/>");

		var person2 = {
			"name": "张三",
			"age": 23,
			"gender": true
		};
		document.write(person2 + "<br/>");
		document.write(typeof person2 + "<br/>");

		// 嵌套格式,定义一组对象集合
		var persons = {
			"persons": [{
					name: "张三",
					age: 23,
					gender: true
				},
				{
					name: "张三",
					age: 23,
					gender: true
				},
				{
					name: "张三",
					age: 23,
					gender: true
				}
			]
		};
		document.write(persons + "<br/>");

		// JSON 数组格式：中括号中嵌套对象，定义一组对象集合
		var ps = [{
				name: "张三",
				age: 23,
				gender: true
			},
			{
				name: "张三",
				age: 23,
				gender: true
			},
			{
				name: "张三",
				age: 23,
				gender: true
			}
		];
		document.write(ps + "<br/><hr/>");
	</script>
	<!-- 获取 JSON 中的数据 -->
	<script type="application/javascript">
		// 1.JSON 对象.属性
		document.write(person.name + "<br/>");
		document.write(person.age + "<br/>");
		document.write(person.gender + "<br/>");

		// 2.JSON对象.键[角标]
		var p = persons.persons[2];
		document.write(p.name + "<br/>");
		document.write(p.age + "<br/>");
		document.write(p.gender + "<br/>");
		
		// JSON 对象["键名"]
		document.write(person["name"] + "<br/>");
		document.write(person["age"] + "<br/>");
		document.write(person["gender"] + "<br/>");

		// 3.获取对象数组中的对象  JSON 数组[索引]
		var op = ps[2];
		document.write(op.name + "<br/>");
		document.write(op.age + "<br/>");
		document.write(op.gender + "<br/><hr/>");
	</script>
	<!-- JSON 遍历-->
	<script type="application/javascript">
		// 1.遍历对象的属性
		for(var key in person) {
			document.write(key + ":" + person[key] + "<br/>");
		}

		// 获取数组中的对象,双重循环遍历
		for (var i = 0; i < ps.length; i++) {
			var mp = ps[i];
			for (var key in mp) {
				document.write(key + ":" + mp[key] + "<br/>");
			}
		}
		document.write("<hr/>");
	</script>
	<!-- JSON 常用方法-->
	<script type="application/javascript" >
		// 把 json 对象转换成为 json 字符串
		// 与 Java 中对象的 toString
		var json = JSON.stringify(person);
		document.write(json+"<br/>");

		// 把 json 字符串。转换成为 json 对象
		var obj = JSON.parse(json);
		document.write(obj+"<br/><hr/>")
	</script>
	<body>

	</body>

</html>