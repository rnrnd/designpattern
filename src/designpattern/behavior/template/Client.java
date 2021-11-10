package designpattern.behavior.template;

public class Client {
	public static void main(String[] args) {
		Framework framework = new App();
		framework.templateMethod();
	}
}
