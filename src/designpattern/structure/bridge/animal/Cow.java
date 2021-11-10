package designpattern.structure.bridge.animal;

public class Cow extends Animal{
	public Cow(Food food, Sound sound) {
		super(food, sound);
	}

	@Override
	public void yell() {
		System.out.println("牛叫了：" + sound.getSound());
	}

	@Override
	public void eat() {
		System.out.println("牛吃" + food.getFood());
	}
}
