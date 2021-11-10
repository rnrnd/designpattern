package designprinciple.liskovsubstitution;

/**
 * 里氏替换原则：所有引用父类的地方，都能透明的使用其子类对象，功能不发生改变
 * 在这个原则下，子类尽量不要重写父类方法
 * 继承实际上让两个类的耦合增强，在适当情况下可通过聚合、组合、依赖解决问题，而不是继承
 * 当需要对父类的方法重写时，“做父子不如当兄弟”
 */
public class LiskovSubstitution {
    /**
     * 1.继承包含的含义：父类中已经实现的方法实际上是在设定规范和契约，虽然不强制要求子类遵循这些契约，但如果子类对这些方法任意修改，会对整个继承体系造成破坏
     * 2.继承在给程序设计带来便利的同时，也给程序带来侵入性，降低程序的可移植性，增加对象间的耦合，父类需要做出修改时，必须考虑对所有子类的影响
     */
}
