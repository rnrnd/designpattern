package designpattern.structure.bridge.animal;

public abstract class Animal {

	protected Food food;
	protected Sound sound;

	public Animal(Food food, Sound sound) {
		this.food = food;
		this.sound = sound;
	}

	public abstract void yell();

	public abstract void eat();

	public void changeFood(Food food) {
		this.food = food;
	}
}
