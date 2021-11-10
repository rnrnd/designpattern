package juc;

import java.util.*;

public class Demo3 {
	public static void main(String[] args) {
		List list = Collections.synchronizedList(new ArrayList());
		for (int i = 0; i < 20; i++) {
			new Thread(()->{
				list.add(UUID.randomUUID().toString().substring(0,5));
				System.out.println(list);
			}).start();
		}
		NavigableMap<Object, Object> map = Collections.synchronizedNavigableMap(new TreeMap<>());
	}
}
