package designpattern.creation.factorymethod;

/**
 *
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{

                new Application(ConcreteFactoryA.getInstance().createProduct()).showFeature();
                new Application(ConcreteFactoryB.getInstance().createProduct()).showFeature();
            }).start();
        }

    }
}
@FunctionalInterface
interface Product {

    void feature();

}
class ProductA implements Product {

    @Override
    public void feature() {
        System.out.println("productA's feature...");
    }
}
class ProductB implements Product {

    @Override
    public void feature() {
        System.out.println("productB's feature...");
    }
}
@FunctionalInterface
interface ProductFactory {
    abstract Product createProduct();
}
class ConcreteFactoryA implements ProductFactory {
    private ConcreteFactoryA(){}
    private static volatile ConcreteFactoryA instance;
    public static ConcreteFactoryA getInstance(){
        if (instance == null) {
            synchronized (ConcreteFactoryA.class) {
                if (instance == null) {
                    instance = new ConcreteFactoryA();
                }
            }
        }
        return instance;
    }
    @Override
    public Product createProduct() {
        ProductA productA = new ProductA();
        //添加预处理
        //...
        //...
        return productA;
    }
}
class ConcreteFactoryB implements ProductFactory {
    private ConcreteFactoryB(){}
    private static volatile ConcreteFactoryB instance;
    public static ConcreteFactoryB getInstance(){
        if (instance == null) {
            synchronized (ConcreteFactoryB.class) {
                if (instance == null) {
                    instance = new ConcreteFactoryB();
                }
            }
        }
        return instance;
    }
    @Override
    public Product createProduct() {
        ProductB productB = new ProductB();
        //添加预处理
        //...
        //...
        return productB;
    }
}
class Application {

    private Product product;
    ProductFactory productFactory = () -> {
        return product;
    };
    public Application(Product product) {
        this.product = product;
    }
    //业务逻辑
    void showFeature() {

        product.feature();

    }
}
