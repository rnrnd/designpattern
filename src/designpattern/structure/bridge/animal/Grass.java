package designpattern.structure.bridge.animal;

public class Grass implements Food{
	@Override
	public String getFood() {
		return "草";
	}
}
