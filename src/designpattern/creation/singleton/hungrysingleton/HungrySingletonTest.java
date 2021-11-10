package designpattern.creation.singleton.hungrysingleton;

public class HungrySingletonTest {
    public static void main(String[] args) {
        new Thread(()->{
            HungrySingleton getInstance = HungrySingleton.getInstance();
            System.out.println(getInstance);
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

    private static void run() {
        HungrySingleton getInstance = HungrySingleton.getInstance();
        System.out.println(getInstance);
    }
}
class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){}

    public static HungrySingleton getInstance() {
        return instance;
    }

}
