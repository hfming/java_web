// 自定义对象创建方式一:无参构造函数
function Person() {
	document.write("constructor()");
	document.write("<br/>")
}
// 创建对象，创建之前需要先定义对象
var person = new Person();
// 定义属性赋值
person.name = "jack";
person.age = 23;
// 定义方法
person.work = function() {
	document.write("person working...<br/>");
};
// 获取构造函数
document.write(person.constructor + "<br/>");
// 获取对象属性值
document.write(person.name + "," + person.age + "<br/>");
// 调用对象方法
person.work();
document.write("<br/>");

// 自定义对象创建方式二：有参数构造函数
function Person(name, age) {
	this.name = name;
	this.age = age;
	this.work = function() {
		document.write(this.name + ":" + this.age);
	};
}
var person = new Person("jack", 28);
//person.work();
document.write("<br/>");

// 自定义对象创建方式三：new Object() 方式
var person = new Object();
// 对象属性
person.name = "jack";
person.age = 24;
// 创建对象方法
person.sayHello = function() {
	document.write(this.name + ":" + this.age);
}
person.sayHello();
document.write("<br/>");

// 自定义对象创建方式四：字面量方式
var person = {
	name: "李四",
	age: 88,
	eat: function() {
		document.write("eating...");
	}
};
document.write(person.name + person.age + "<br/>");
person.eat();
document.write("<br/>");

// 完整定义对象
function Person() {
	var id;
	var name;
	var password;

	function Person(id, name, password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	function toString() {
		return "id：" + this.id + "name：" + this.name + "password：" + this.password;
	}
}
var p = new Person(001, "hfm", "111");
document.writeln(p.toString());
document.write("<br/><hr/>");