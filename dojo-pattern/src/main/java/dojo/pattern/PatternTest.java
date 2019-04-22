/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: PatternTest
 * Author:   hthn
 * Date:     2019-04-22 13:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dojo.pattern;


import com.sun.xml.internal.xsom.XSWildcard;
import dojo.pattern.factory.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hthn
 * @create 2019-04-22
 * @since 1.0.0
 */
public class PatternTest {
    public static void main(String[] args) {
        // 1 创建型模式
        // 1.1 工厂模式
        testSimpleFactory();
    }

    private static void testSimpleFactory() {
        System.out.println("PatternTest -- Factory");

        SimpleFactory simpleFactory = new SimpleFactory();
        AliPay aPay = (AliPay) simpleFactory.getPayObject("ali");
        System.out.println(aPay.pay());
        WechatPay wechatPay = (WechatPay) simpleFactory.getPayObject("wechat");
        System.out.println(wechatPay.pay());
        // 新增银联支付， 需要
        // 1. 增加新类 UnionPay
        // 2. 更改 SimpleFactory，增加新的 if 分支
        // 缺点：
        // 1. 工厂类的职责相对过重，增加新的产品时需要修改工厂类的判断逻辑，违背开闭原则。
        // 2. 不易于扩展过于复杂的产品结构
        UnionPay unionPay = (UnionPay) simpleFactory.getPayObject("union");
        System.out.println(unionPay.pay());
    }
}
