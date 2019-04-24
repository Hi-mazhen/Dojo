package dojo.pattern.singleton.hungrysingleton;

public class HungrySingleton {
    // 只有一个实例
    // 构造函数私有
    // 全局访问点


//    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    // 静态代码块方式
    private static final HungrySingleton hungrySingleton;
    static {
        hungrySingleton = new HungrySingleton();
    }

    private HungrySingleton () {}

    public static HungrySingleton getInstance () {
        return hungrySingleton;
    }


}
