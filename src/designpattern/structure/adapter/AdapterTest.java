package designpattern.structure.adapter;

import java.io.*;

/**
 * 如果一个类不能直接访问另一个类，中间加一个类转接一下，就是适配器模式
 * 适用场景：
 *      1.当你希望使用某些现有类，但其接口与其他代码不兼容时，使用适配器模式（对象适配器，也就是聚合使用）
 *      2.当你希望重用几个现有子类，但是子类缺少一些不能添加到超类的功能时，使用适配器模式（类适配器，也就是继承使用）
 */
public class AdapterTest {
	public static void main(String[] args) throws FileNotFoundException {
		/*FileInputStream fis = new FileInputStream("");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader reader = new BufferedReader(isr);*/

		Target target = new ClassAdapter();
		target.request();

		target = new ObjectAdapter(new ConcreteAdptee());
		target.request();
	}
}
