package designpattern.structure.proxy;

import java.util.Random;

/**
 * 代理模式是用于扩展原有功能，添加自己的逻辑，静态代理从细节上与decorator相似，只不过是思想上不一样
 */
public class StaticProxyExample {
	public static void main(String[] args) {

		Movable m = new TimeProxy(
				new LogProxy(
						new Tank()
				)
		);
		m.move();

		Movable movable = new Tank();
		movable = new TimeProxy(movable);
		movable = new LogProxy(movable);
		movable.move();
	}
}

class LogProxy implements Movable {
	//这里如果是使用Tank这种具体实现，貌似更能表现出代理模式，但同时无法灵活使用多代理
	//使用通用接口，能实现同时使用多代理，但从细节上貌似更像是装饰者模式Decorator，设计模式主要侧重于编程思想，同一段代码从不同的角度看，可能就是符合不同的设计模式
	Movable movable;

	public LogProxy(Movable movable) {
		this.movable = movable;
	}
	private void before(){
		System.out.println("before moving...");
	}
	private void after(){
		System.out.println("after moving...");
	}
	@Override
	public void move() {
		before();
		movable.move();
		after();
	}
}
class TimeProxy implements Movable {

	Movable movable;

	public TimeProxy(Movable movable) {
		this.movable = movable;
	}

	@Override
	public void move() {
		long start = System.currentTimeMillis();
		movable.move();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}