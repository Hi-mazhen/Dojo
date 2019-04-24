package dojo.pattern.factory.factorymethod;

import dojo.pattern.factory.IPayment;

public class PayFactoryTest {
    public static void main(String[] args) {
        IPayFactory IPayFactory = new AliPayFactory();
        IPayment iPayment = IPayFactory.create();
        iPayment.pay();

        IPayFactory = new UnionPayFactory();
        iPayment = IPayFactory.create();
        iPayment.pay();

        // 扩展性好，符合开闭原则
        // 扩展后类的个数增多，增加代码复杂性

        // LoggerFactory.getLogger("error");
    }
}
