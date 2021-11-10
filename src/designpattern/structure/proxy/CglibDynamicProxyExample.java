package designpattern.structure.proxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxyExample {
	public static void main(String[] args) {
		Target target = new Target();
		ProxyFactory proxyFactory = new ProxyFactory(target);
		Target proxyInstance = proxyFactory.getProxyInstance();
		proxyInstance.p();
	}
}
class Target {
	public void p(){
		System.out.println("==执行中==");
	}
}
class ProxyFactory implements MethodInterceptor {

	private Object target;

	public ProxyFactory(Object target) {
		this.target = target;
	}

	public <T>T getProxyInstance(){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		return (T) enhancer.create();
	}
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("==执行前==");
		Object result = proxy.invokeSuper(obj, args);
		proxy.invoke(target, args);
		method.invoke(target, args);
		System.out.println("==执行后==");
		return result;
	}
}