package designpattern.structure.bridge.computer;

import designpattern.structure.bridge.computer.brand.Brand;

public class Desktop extends Computer{

	public Desktop(Brand brand) {
		super(brand);
	}

	@Override
	public void info() {
		super.info();
		System.out.println("台式机");
	}
}
