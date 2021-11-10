package designpattern.creation.singleton.enumsingleton;

public enum SingletonHolder {
	INSTANCE(){
		@Override
		public Singleton getInstance() {
			return singleton;
		}
	};

	private static final Singleton singleton = new Singleton();

	public static Singleton getSingleton() {
		return singleton;
	}
	public abstract Singleton getInstance();
	static class Singleton{
		private Singleton(){}
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}
