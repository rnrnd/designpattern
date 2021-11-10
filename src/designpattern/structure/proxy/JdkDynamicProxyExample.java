package designpattern.structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.function.Function;

public class JdkDynamicProxyExample {
	public static void main(String[] args) {
		Tank tank = new Tank();
		Movable movable = (Movable) new MyInvocationHandler(tank).getProxy();
		movable.move();
		Function<String, String> f1 = o-> "hashcode:" + o;
		System.out.println(f1.apply(movable.hashCode()+""));
	}
}
class MyInvocationHandler implements InvocationHandler {

	Object target;

	public MyInvocationHandler(Object target) {
		this.target = target;
	}
	public Object getProxy(){
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(target, args);
	}
}
