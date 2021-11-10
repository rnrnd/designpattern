package designpattern.structure.bridge.animal;

public class Dog extends Animal{

	public Dog(Food food, Sound sound) {
		super(food, sound);
	}

	@Override
	public void yell() {
		System.out.println("狗叫了：" + sound.getSound());
	}

	@Override
	public void eat() {
		System.out.println("狗吃" + food.getFood());
	}
}
