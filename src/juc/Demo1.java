package juc;

import org.junit.Test;

public class Demo1 {

	private static final Object o = new Object();

	public synchronized void test1(){
		System.out.println("test1");
	}
	public void test2(){
		synchronized (o){
			System.out.println("test2");
		}
	}
	@Test
	public void test3() {
		synchronized(Demo1.class){
			System.out.println("test3");
		}
	}
}
