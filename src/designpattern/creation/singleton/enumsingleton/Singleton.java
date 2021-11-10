package designpattern.creation.singleton.enumsingleton;

 class EnumTest {
	public static void main(String[] args) {
		double x = 10, y = 20;
		double result = Operation.PLUS.apply(x, y);
		for (int i = 0; i < 10; i++) {
			new Thread(()->{
				System.out.println(SingletonEnum.INSTANCE.getInstance().hashCode());
			}).start();
		}

	}
}

enum SingletonEnum {
	INSTANCE (){
		Singleton singleton = new Singleton();
		@Override
		public Singleton getInstance() {
			return singleton;
		}
	} ;

	public abstract Singleton getInstance();

	public class Singleton{
		private Singleton() {
		}

		@Override
		public String toString() {
			return "Singleton{}";
		}
	}
}
interface Compute{
 	double compute();
}
enum Operation implements Compute{
	PLUS("+"){
		@Override
		public double compute() {
			return 0;
		}

		@Override
		double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-"){
		@Override
		public double compute() {
			return 0;
		}

		@Override
		double apply(double x, double y) {
			return x - y;
		}
	},
	TIMES("*"){
		@Override
		public double compute() {
			return 0;
		}

		@Override
		double apply(double x, double y) {
			return x * y;
		}
	},
	DIVIDE("/"){
		@Override
		public double compute() {
			return 0;
		}

		@Override
		double apply(double x, double y) {
			return x / y;
		}
	};
	private final String symbol;
	Operation(String symbol) {
		this.symbol = symbol;
	}
	abstract double apply(double x, double y);

	@Override
	public String toString() {
		return symbol;
	}
}