package designpattern.structure.decorator;

public class DecoratorTest {
	public static void main(String[] args) {
		Camera camera = new ConcreteCamera();
		camera = new FilterDecoretor(camera);
		camera = new BeautyDecoretor(camera);
		camera.shoot();
	}
}
abstract class Camera{
	public abstract void shoot();
}
class ConcreteCamera extends Camera {

	@Override
	public void shoot() {
		System.out.println("拍照");
	}
}
abstract class Decoretor extends Camera {
	private Camera camera = null;

	public Decoretor(Camera camera) {
		this.camera = camera;
	}

	@Override
	public void shoot() {
		this.camera.shoot();
	}
}
class FilterDecoretor extends Decoretor {

	public FilterDecoretor(Camera camera) {
		super(camera);
	}
	private void addFilter(){
		System.out.println("加滤镜");
	}

	@Override
	public void shoot() {
		addFilter();
		super.shoot();
	}
}
class BeautyDecoretor extends Decoretor {

	public BeautyDecoretor(Camera camera) {
		super(camera);
	}
	private void beautify(){
		System.out.println("美颜");
	}

	@Override
	public void shoot() {
		beautify();
		super.shoot();
	}
}