package designpattern.creation.builder;

public class Main {
	public static void main(String[] args) {
		Builder builder = new ComplexTerrainBuilder();
		Terrain terrain = builder.buildFort().buildWall().buildMine().build();

		Person person = new Person.PersonBuilder()
				.basicInfo("张三", 18, "nan")
				.location("中山路", "4-403")
				.marriged(false)
				.height(185)
				.wight(75).build();
		System.out.println(person);
	}
}
