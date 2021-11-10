package designpattern.structure.bridge.computer;

import designpattern.structure.bridge.computer.brand.Brand;

public class Laptop extends Computer{
	public Laptop(Brand brand) {
		super(brand);
	}

	@Override
	public void info() {
		super.info();
		System.out.println("笔记本");
	}
}
