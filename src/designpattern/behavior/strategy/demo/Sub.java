package designpattern.behavior.strategy.demo;

public class Sub implements Principle {
	@Override
	public int calculate(int a, int b) {
		return a - b;
	}
}
