package designpattern.behavior.observer;

public interface Observer {
	/**
	 *
	 * @param observable 被观察的对象，对象的某些属性或者数据可能会用到，因而传递给观察者
	 * @param args 通常是传递的数据
	 */
	public void update(Observable observable, Object args);
}
