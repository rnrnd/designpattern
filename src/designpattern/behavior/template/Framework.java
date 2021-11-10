package designpattern.behavior.template;

/**
 * 在面向过程编程思维中，应用开发人员调用框架或库开发人员的代码司空见惯，这种称为早绑定，即晚开发的程雪调用早开发的程序
 * 而在面向对象语言中，由于多态和抽象的存在，可以实现晚绑定，即早开发的程序调用晚开发的程序
 * 框架开发人员定义好固定的算法框架，某些不确定的实现细节使用抽象方法交给应用开发人员实现，框架开发人员只需要在固定框架中调用抽象方法
 */
public abstract class Framework {
	public final void templateMethod(){
		step1();
		step2();
		hook();
		step3();
		step4();
	}
	private void step1(){
		System.out.println("步骤1");
	}
	private void step2(){
		System.out.println("步骤2");
	}
	abstract void step3();

	private void step4(){
		System.out.println("步骤4");
	}

	/**
	 * 钩子方法：
	 * 某些情况下，提供一个空方法，在固定流程中的合适位置调用这个方法
	 * 子类如有需要，可以覆盖这个方法添加自己的逻辑，如无需要即可无视
	 * 比如spring AbstractApplicationContext中的onRefresh，如果需要在上下文刷新的时候添加逻辑，就可以覆盖这个方法
	 * 还有aop中的前置、后置这些advice
	 */
	protected void hook(){

	}

}
