package designpattern.creation.abstractfactory;

/**
 * 工厂方法模式中考虑的是一类产品的生产，如畜牧场只养动物、电视机厂只生产电视机、计算机软件学院只培养计算机软件专业的学生等。
 * 工厂方法模式只考虑生产同等级的产品，但是在现实生活中许多工厂是综合型的工厂，能生产多等级（种类） 的产品，
 * 如农场里既养动物又种植物，电器厂既生产电视机又生产洗衣机或空调，大学既有软件专业又有生物专业等。
 * 抽象工厂（AbstractFactory）模式的定义：是一种为访问类提供一个创建一组相关或相互依赖对象的接口，且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构。
 *
 * 抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品。
 *
 * 使用抽象工厂模式一般要满足以下条件。
 * 系统中有多个产品族，每个具体工厂创建同一族但属于不同等级结构的产品。
 * 系统一次只可能消费其中某一族产品，即同族的产品一起使用。
 *
 * 抽象工厂模式除了具有工厂方法模式的优点外，其他主要优点如下。
 * 可以在类的内部对产品族中相关联的多等级产品共同管理，而不必专门引入多个新的类来进行管理。
 * 当需要产品族时，抽象工厂可以保证客户端始终只使用同一个产品的产品组。
 * 抽象工厂增强了程序的可扩展性，当增加一个新的产品族时，不需要修改原代码，满足开闭原则。<br/>
 *
 * 其缺点是：当产品族中需要增加一个新的产品时，所有的工厂类都需要进行修改。增加了系统的抽象性和理解难度。
 * 模式的结构与实现
 * 1. 模式的结构
 * 抽象工厂模式的主要角色如下。
 * 抽象工厂（Abstract Factory）：提供了创建产品的接口，它包含多个创建产品的方法 newProduct()，可以创建多个不同等级的产品。
 * 具体工厂（Concrete Factory）：主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建。
 * 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品。
 * 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间是多对一的关系。
 *
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        Farm farm = new Farm4();
        Plant plant = farm.plant();
        plant.grow();
        Animal animal = farm.breed();
        animal.eat(plant);
    }
}
interface Plant{
    String getName();
    void grow();
}
interface Animal{
    void eat(Plant plant);
}
interface Farm {
    Plant plant();
    Animal breed();
}
//高粱
class Sorghum implements Plant {

    @Override
    public String getName() {
        return "Sorghum";
    }

    @Override
    public void grow() {
        System.out.println("Sorghum is growing...");
    }
}
/**
 * 苜蓿
 */
class Alfalfa implements Plant {

    @Override
    public String getName() {
        return "Alfalfa";
    }

    @Override
    public void grow() {
        System.out.println("Alfalfa is growing...");
    }
}
class Horse implements Animal{

    @Override
    public void eat(Plant plant) {
        System.out.println("Horse is eating " + plant.getName());
    }
}
class Cow implements Animal {

    @Override
    public void eat(Plant plant) {
        System.out.println("Cow is eating " + plant.getName());
    }
}
class Farm1 implements Farm {

    @Override
    public Plant plant() {
        return new Alfalfa();
    }

    @Override
    public Animal breed() {
        return new Horse();
    }
}
class Farm2 implements Farm {

    @Override
    public Plant plant() {
        return new Alfalfa();
    }

    @Override
    public Animal breed() {
        return new Cow();
    }
}
class Farm3 implements Farm {

    @Override
    public Plant plant() {
        return new Sorghum();
    }

    @Override
    public Animal breed() {
        return new Horse();
    }
}
class Farm4 implements Farm {

    @Override
    public Plant plant() {
        return new Sorghum();
    }

    @Override
    public Animal breed() {
        return new Cow();
    }
}