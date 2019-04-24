/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: SimpleFactoryTest
 * Author:   hthn
 * Date:     2019-04-24 13:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dojo.pattern.factory.simple;

import dojo.pattern.factory.AliPay;
import dojo.pattern.factory.UnionPay;
import dojo.pattern.factory.WechatPay;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hthn
 * @create 2019-04-24
 * @since 1.0.0
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        System.out.println("PatternTest -- SimpleFactory");

        SimpleFactory simpleFactory = new SimpleFactory();

        // 缺点：
        // 1. 增加新的产品时需要修改工厂类的判断逻辑，违背开闭原则。
        // 2. 不易于扩展过于复杂的产品结构
        // AliPay aPay = (AliPay) simpleFactory.getPay("ali");
        // aPay.pay();

        AliPay aPay = (AliPay) simpleFactory.create("dojo.pattern.factory.AliPay");
        aPay.pay();

        WechatPay wechatPay = (WechatPay) simpleFactory.create(WechatPay.class);
        wechatPay.pay();

        UnionPay unionPay = (UnionPay) simpleFactory.create(UnionPay.class);
        unionPay.pay();

    }
}
