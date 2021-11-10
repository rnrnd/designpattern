package java8;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	List<Employee> employees = Arrays.asList(
			new Employee("张三",17),
			new Employee("李四",20),
			new Employee("王五",35),
			new Employee("赵六",42),
			new Employee("田七",15)
	);
	//创建流
	@Test
	public void test1(){
		//1.通过Collection系列集合提供的stream()方法和parallelStream()方法
		ArrayList<String> list = new ArrayList<>();
		Stream<String> stream1 = list.stream();

		//2.通过Arrays.stream()方法
		Integer[] array = new Integer[10];
		Stream<Integer> stream2 = Arrays.stream(array);

		//3.通过Stream.of()
		Stream<String> stream3 = Stream.of("aa", "bb");

		//4.通过Stream.iterate()，产生的是有序的无限流
		Stream<Integer> stream4 = Stream.iterate(0, x -> x + 2);

		//5.通过Stream.generate(),产生的是无序的无限流
		Stream<Double> stream5 = Stream.generate(Math::random);
	}
	@Test
	public void test2(){
		Map<String, List<Employee>> collect = employees.stream()
													   .collect(Collectors.groupingBy(
															e -> {
																if (e.getAge() > 18) {
																	return "成年";
																} else {
																	return "未成年";
																}
															}
													));
		System.out.println(collect);
	}
}
