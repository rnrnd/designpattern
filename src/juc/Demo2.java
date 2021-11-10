package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo2 {
	public static void main(String[] args) {
		Data data = new Data();
		for (int i = 0; i < 10; i++) {
			new Thread(data::a).start();
		}
		for (int i = 0; i < 10; i++) {
			new Thread(data::b).start();
		}
		for (int i = 0; i < 10; i++) {
			new Thread(data::c).start();
		}

	}

	static class Data {
		Lock lock = new ReentrantLock();
		Condition cond1 = lock.newCondition();
		Condition cond2 = lock.newCondition();
		Condition cond3 = lock.newCondition();
		int num= 1;
		public void a(){
			lock.lock();
			try {
				while( num != 1) {
					cond1.await();
				}
				System.out.println(Thread.currentThread().getName() +"=>" + num);
				num = 2;
				cond2.signal();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		public void b(){
			lock.lock();
			try {
				while( num != 2) {
					cond2.await();
				}
				System.out.println(Thread.currentThread().getName() +"=>" + num);
				num = 3;
				cond3.signal();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		public void c(){
			lock.lock();
			try {
				while( num != 3) {
					cond3.await();
				}
				System.out.println(Thread.currentThread().getName() +"=>" + num);
				num = 1;
				cond1.signal();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}
}
