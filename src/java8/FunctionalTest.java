package java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/*
java8函数式编程内置的四大接口

1.Consumer<T> 消费型接口，接收参数无返回值
	void accept(T t);

2.Supplier<T> 供给型接口，无参数有返回值
	T get();

3.Function<T, R> 函数型接口，有参数有返回值
	R apply(T t);

4.Predicate<T> 断言型接口，接收参数做判断返回boolean值
	boolean test(T t);
 */
public class FunctionalTest {
	/**方法引用:
	 * 如果函数式的方法体内执行的细节只有对某个方法的调用（只有一句代码），并且函数式的参数和返回值类型与该方法一致，则可以::进行方法调用
	 * 1.对象::实例方法名
	 * 2.类名::静态方法名
	 * 3.类名::实例方法名 这种情况只有在第一个参数是方法的调用者，第二个参数不存在或者是方法的参数时才可用
	 */
	@Test
	public void test1(){
		//对象::实例方法名
		Consumer<String> cons = s -> System.out.println(s);
		Consumer<String> consumer = System.out::println;
		consumer.accept("hello");

		//类名::静态方法名
		Comparator<Integer> comp = (x,y) -> Integer.compare(x, y);
		Comparator<Integer> comparator = Integer::compare;

		//类名::实例方法名
		BiFunction<String, String, String> func = (s1, s2) -> s1.concat(s2);
		BiFunction<String, String, String> function = String::concat;
		String result = function.apply("123", "456");
		System.out.println(result);
	}
	//构造器引用  类名::new
	@Test
	public void test2(){
		Supplier<Person> sup1 = Person::new;
		BiFunction<String, Integer, Person> bf = Person::new;
		Person person1 = sup1.get();
		Person person2 = bf.apply("Jack", 18);
	}
	//数组引用 类名[]::new
	@Test
	public void test3(){
		Random random = new Random();
		Function<Integer, Person[]> function1 = i -> new Person[i];
		Function<Integer, Person[]> function2 = Person[]::new;
		Person[] peoples = function2.apply(10);
		Supplier<Person> sup1 = Person::new;
		for (int i = 0; i < 10; i++) {
			peoples[i] = sup1.get();
		}
		Consumer<Person> consumer = person -> {
			person.setAge((int) (Math.random()*100));
			String name = "";
			for (int i = 0; i < 6; i++) {
				name += (char)(97 + random.nextInt(26));
			}
			person.setName(name);
		};
		Arrays.stream(peoples).iterator().forEachRemaining(consumer);
		for (Person people : peoples) {
			System.out.println(people);
		}
	}
	static class Person{
		private String name;
		private Integer age;

		public Person(String name, Integer age) {
			this.name = name;
			this.age = age;
		}

		public Person() {
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person{" +
					"name='" + name + '\'' +
					", age=" + age +
					'}';
		}
	}
}
