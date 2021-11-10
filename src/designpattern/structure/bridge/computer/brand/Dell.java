package designpattern.structure.bridge.computer.brand;

public class Dell implements Brand{
	@Override
	public void info() {
		System.out.print("戴尔");
	}
}
