package designpattern.structure.bridge.animal;

public class Cat extends Animal{
	public Cat(Food food, Sound sound) {
		super(food, sound);
	}

	@Override
	public void yell() {
		System.out.println("猫叫了:" + sound.getSound());
	}

	@Override
	public void eat() {
		System.out.println("猫吃" + food.getFood());
	}
}
