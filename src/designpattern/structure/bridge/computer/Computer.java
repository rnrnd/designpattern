package designpattern.structure.bridge.computer;

import designpattern.structure.bridge.computer.brand.Brand;

public abstract class Computer {
	//将变化的一部分聚合到变化的另一部分
	protected Brand brand;

	public Computer(Brand brand) {
		this.brand = brand;
	}
	public void info(){
		brand.info();
	}
}
