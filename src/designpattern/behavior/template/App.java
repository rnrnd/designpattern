package designpattern.behavior.template;

public class App extends Framework{
	@Override
	void step3() {
		System.out.println("步骤三");
	}

	@Override
	protected void hook() {
		System.out.printf("钩子方法按需添加逻辑");
	}
}
