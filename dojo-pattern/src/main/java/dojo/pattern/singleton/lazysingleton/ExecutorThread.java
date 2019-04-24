package dojo.pattern.singleton.lazysingleton;

public class ExecutorThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : " + LazySimpleSingleton.getInstance());
    }
}
