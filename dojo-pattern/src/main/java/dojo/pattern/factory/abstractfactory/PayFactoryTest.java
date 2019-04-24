package dojo.pattern.factory.abstractfactory;

import dojo.pattern.factory.IPayment;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class PayFactoryTest {
    public static void main(String[] args) {
        IPayFactory iPayFactory = new AliFactory();
        IPayment iPayment = iPayFactory.createPayment();
        iPayment.pay();
        ISignature iSignature = iPayFactory.createSignature();
        iSignature.sign();

        // 不符合开闭原则，但是很好扩展
        // 产品族不经常更改

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
    }
}
