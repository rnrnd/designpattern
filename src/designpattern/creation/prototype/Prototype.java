package designpattern.creation.prototype;

/**
 * 原型模式通常需要做两点：
 * 1.实现Cloneable接口
 * 2.重写Object的clone()方法
 * 浅克隆：只把当前对象直接复制，包括对象内的成员变量，如果是引用类型（非基本类型），复制得来的对象与原对象引用的是相同的对象地址，
 *       所以对原对象的成员变量修改时，处置对象会跟着变，特例是String类型属性，由于是final修饰且存在字符串常量池，修改时会产生新的字符串对象，
 *       原对象依然存在且放入常量池，复制对象引用的还是原来的对象
 * 深克隆：克隆时，在重写clone方法里对引用类型也进行克隆
 */
public class Prototype implements Cloneable{
	private String name;
	private Integer age;
	private Location location;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	protected Prototype clone() throws CloneNotSupportedException {
		Prototype clone = (Prototype) super.clone();
		clone.location = (Location) this.location.clone();
		return clone;
	}

	private static class Location implements Cloneable{
		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Prototype prototype = new Prototype();
		prototype.setAge(new Integer(18));
		prototype.setName("zhangsan");
		prototype.setLocation(new Location());

		Prototype clone = (Prototype) prototype.clone();
		System.out.println(clone == prototype);
		System.out.println(clone.name == prototype.name);

		prototype.name = "lisi";
		System.out.println(clone.name == prototype.name);
		System.out.println("clone.name=" + clone.name);
	}
}
