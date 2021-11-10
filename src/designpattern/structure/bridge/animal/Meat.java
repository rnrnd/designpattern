package designpattern.structure.bridge.animal;

public class Meat implements Food{
	@Override
	public String getFood() {
		return "肉";
	}
}
