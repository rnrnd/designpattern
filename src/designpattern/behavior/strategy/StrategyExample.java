package designpattern.behavior.strategy;

/**
 * 定义一系列算法，把他们一个个封装起来，并且是他们之间可以互相替换，达到算法独立于使用它的客户而变化的目的,
 * 还有一个方式，如果策略是基本可以确定的，那么枚举策略更为直观，比如实现加减乘除
 */
public class StrategyExample {
	public static void main(String[] args) {
		Strategy strategy = new ConcreteStrategy();
		Context context = new Context(strategy);
		context.doAnything();
	}
}
interface Strategy {
	//运算规则接口
	void rule();
}
class ConcreteStrategy implements Strategy{
	@Override
	public void rule() {
		System.out.println("具体的算法实现");
	}
}
/*Context类屏蔽高层模块对策略、算法的直接访问，封装出可能的变化，提供功能或服务给使用者*/
class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}
	//封装方法
	public void doAnything(){

		strategy.rule();
	}
}
