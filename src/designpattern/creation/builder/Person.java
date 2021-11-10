package designpattern.creation.builder;
/*
建造者模式，使得复杂对象的创建与使用分离，标准情况下有四个角色，Product,Builder,ConcreteBuilder,Director
Product:被建造出的对象
Builder:定义建造过程中的接口方法
ConcreteBuilder:实现Builder,不同的实现建造出不同的对象
Director:指挥者，定义建造流程

	在实际使用过程中，通常会简化使用，比如下面的例子,
	工作中可能的业务场景是，有时候我们只能掌握人员的基本信息，而且这也是我们业务必须的信息，其他信息则可以缺失，
	于是我们把必需的基本信息封装在basicInfo方法中，其他信息视情况而定，有则调用相应方法，没有就免了
 */

public class Person {

	private Person(){}

	private String name;
	private int age;
	private String sex;
	private float wight;
	private float height;
	private boolean marriged;
	private Location location;

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", sex='" + sex + '\'' +
				", wight=" + wight +
				", height=" + height +
				", marriged=" + marriged +
				", location=" + location +
				'}';
	}

	public static class PersonBuilder {
		private Person person = new Person();
		PersonBuilder basicInfo(String name, int age, String sex) {
			person.sex = sex;
			person.age = age;
			person.name = name;
			return this;
		}
		PersonBuilder wight(float wight) {
			person.wight = wight;
			return this;
		}
		PersonBuilder height(float height) {
			person.height = height;
			return this;
		}
		PersonBuilder marriged(boolean isMarriged) {
			person.marriged = isMarriged;
			return this;
		}
		PersonBuilder location(String street, String room) {
			this.person.location = new Location(street, room);
			return this;
		}
		Person build(){
			return this.person;
		}
	}


}
class Location {
	private String street;
	private String roomNumber;

	public Location(String street, String roomNumber) {
		this.street = street;
		this.roomNumber = roomNumber;
	}

	@Override
	public String toString() {
		return "Location{" +
				"street='" + street + '\'' +
				", roomNumber='" + roomNumber + '\'' +
				'}';
	}
}