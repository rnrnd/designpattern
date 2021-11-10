package designpattern.structure.bridge.computer.brand;

public class Apple implements Brand {
	@Override
	public void info() {
		System.out.print("苹果");
	}
}
