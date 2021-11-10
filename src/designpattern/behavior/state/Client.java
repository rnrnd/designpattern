package designpattern.behavior.state;

/**
 * 状态机的四大概念。
 *
 * State ，状态。一个状态机至少要包含两个状态。例如上面灯泡的例子，有 灯泡亮和 灯泡灭两个状态。
 *
 * Event ，事件。事件就是执行某个操作的触发条件或者口令。对于灯泡，“打开开关”就是一个事件。
 *
 * Action ，动作。事件发生以后要执行动作。例如事件是“打开开关”，动作是“开灯”。编程的时候，一个 Action 一般就对应一个函数。
 *
 * Transition ，变换。也就是从一个状态变化为另一个状态。例如“开灯过程”就是一个变换。
 *
 */
public class Client {
	public static void main(String[] args) {
		Context context = new Context();
		context.transferState(Context.openingState);
		context.open();
		context.close();
		context.run();
		context.stop();
	}
}
