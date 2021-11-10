package designpattern.creation.singleton.innerclasssingleton;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * 静态内部类方式实现单例
 * 也是一种懒汉模式
 * 在第一次调用getInstance()方法时，jvm才加载内部类，完成初始化
 */
class InnerClassSingleton implements Serializable {
    /**
     * 不加序列化版本号的话，序列化和反序列化都会由jvm动态分配
     * 导致版本号不一致，反序列化失败
     */
    static final long serialVersionUID = 42L;
    private InnerClassSingleton(){
        if (InnerClassHolder.instance != null) {
            throw new RuntimeException("单例模式不允许多个实例对象");
        }
    }

    private static class InnerClassHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance(){
        return InnerClassHolder.instance;
    }

    /**
     * 实现了该方法，ObjectInputStream.readObject()执行时会被替换为这个
     * @return
     * @throws ObjectStreamException
     */
    /*Object readResolve() throws ObjectStreamException {
        return getInstance();
    }*/

    /**
     * 实现了该方法，ObjectOutputStream.writeObject()执行时会被替换为这个
     * @return
     * @throws ObjectStreamException
     */
    /*Object writeReplace() throws ObjectStreamException{
        return getInstance();
    }*/

}
public class InnerClassSingletonTest{
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        /*Constructor<InnerClassSingleton> constructor = InnerClassSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        InnerClassSingleton innerClassSingleton = constructor.newInstance();
        System.out.println(instance == innerClassSingleton);*/

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("InnerClassSingletonSerialize"));
        oos.writeObject(instance);
        oos.close();
        
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("InnerClassSingletonSerialize"));
        InnerClassSingleton innerClassSingleton = ((InnerClassSingleton) ois.readObject());
        System.out.println(instance == innerClassSingleton);

    }
}