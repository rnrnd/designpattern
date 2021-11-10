package designpattern.creation.singleton.enumsingleton;

public class Client {
	public static void main(String[] args) {
		SingletonHolder.Singleton singleton = SingletonHolder.INSTANCE.getSingleton();
		SingletonHolder.Singleton instance = SingletonHolder.INSTANCE.getInstance();
	}
}
