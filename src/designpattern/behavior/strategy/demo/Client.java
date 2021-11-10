package designpattern.behavior.strategy.demo;

public class Client {
	public static void main(String[] args) {
		Principle add = new Add();
		Principle sub = new Sub();
		Calculator calculator = new Calculator();
		calculator.setPrinciple(add);
		int result = calculator.calculate(1, 2);

		calculator.setPrinciple(sub);
		result = calculator.calculate(1, 2);
	}
}
