package designpattern.behavior.strategy.demo;

public class Calculator {
	private Principle principle;

	public void setPrinciple(Principle principle) {
		this.principle = principle;
	}

	public int calculate(int a, int b) {
		return principle.calculate(a, b);
	}
}
