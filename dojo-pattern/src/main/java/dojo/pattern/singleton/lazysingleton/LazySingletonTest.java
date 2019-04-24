package dojo.pattern.singleton.lazysingleton;

public class LazySingletonTest {


    public static void main(String[] args) {
        // 简单测试
//        System.out.println(LazySimpleSingleton.getInstance());

        // 线程不安全
        Thread t1 = new Thread(new ExecutorThread());
        Thread t2 = new Thread(new ExecutorThread());
        t1.start();
        t2.start();

        System.out.println("end");
    }
}
