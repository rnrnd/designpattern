package designpattern.behavior.mediator;

public class Mediator {
	private Service1 service1 = new Service1();
	private Service2 service2 = new Service2();
	private Service3 service3 = new Service3();
	public void task1(){
		service2.method2();
		service3.method3();
	}
}
