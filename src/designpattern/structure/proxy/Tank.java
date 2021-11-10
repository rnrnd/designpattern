package designpattern.structure.proxy;

import java.util.Random;

class Tank implements Movable {

	@Override
	public void move() {
		try {
			System.out.println("tank is moving...");
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
