package juc;

public class Demo5 {
	private Object o = new Object();

	public synchronized void a(){
		System.out.println("a");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public synchronized void b(){
		System.out.println("b");
	}

	public static void main(String[] args) {
		Demo5 d = new Demo5();
		new Thread(d::a, "t1").start();
		new Thread(d::b, "t2").start();
	}
}
