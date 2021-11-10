package designpattern.structure.bridge;

import designpattern.structure.bridge.animal.*;
import designpattern.structure.bridge.computer.AppleLaptop;
import designpattern.structure.bridge.computer.Computer;
import designpattern.structure.bridge.computer.Desktop;
import designpattern.structure.bridge.computer.Laptop;
import designpattern.structure.bridge.computer.brand.Apple;
import designpattern.structure.bridge.computer.brand.Brand;
import designpattern.structure.bridge.computer.brand.Dell;

/**
 * 桥接模式：分离抽象与具体，使它们两部分都可以独立的变化，用聚合链接抽象与具体，这个聚合的变量就是桥
 * 抽象通常是abstract class而不是interface,因为：
 *      1.我们要定义一个聚合实现部分的变量，并在构造器中初始化，这样在子类中就必须也申明这样的有参构造，而interface的话，聚合的变量需要初始化
 *      2.我们定义的行为有时候是抽象方法，对行为的实现放在子类中，但同样的，我们有时候也需要在父类方法中执行共有的逻辑，子类重写时只需调用一下父类方法，因此需要保持灵活
 *
 */
public class BridgeTest {
	public static void main(String[] args) {
		Brand apple = new Apple();
		Computer appleDesktop = new Desktop(new Apple());
		appleDesktop.info();
		Computer dellLaptop = new Laptop(new Dell());
		dellLaptop.info();
		AppleLaptop appleLaptop = new AppleLaptop((Apple) apple);
		appleLaptop.info();

		Food meat = new Meat();
		Sound dogSound = new 汪汪汪();
		Animal dog = new Dog(meat, dogSound);
		dog.yell();
		dog.eat();
		Food dogFood = new 狗粮();
		dog.changeFood(dogFood);
		dog.eat();
		Grass grass = new Grass();
		Sound cowSound = new 哞();
		Animal cow = new Cow(grass, cowSound);
		cow.yell();
		cow.eat();
		Sound catSound = new 喵呜();
		Animal cat = new Cat(meat, catSound);
		cat.yell();
		cat.eat();
	}

}
