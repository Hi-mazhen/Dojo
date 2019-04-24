/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: SimpleFactory
 * Author:   hthn
 * Date:     2019-04-22 20:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dojo.pattern.factory.simplefactory;

import dojo.pattern.factory.IPayment;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hthn
 * @create 2019-04-22
 * @since 1.0.0
 */
public class SimpleFactory {


    // public IPayment create(String payName) {
    //
    //     if ("ali".equals(payName)) {
    //         return new AliPayment();
    //     }
    //
    //     if ("wechat".equals(payName)) {
    //         return new WechatPayment();
    //     }
    //
    //     if ("union".equals(payName)) {
    //         return new UnionPayment();
    //     }
    //     return null;
    // }

    public IPayment create(String className) {
        try {
            if (!((null == className) || ("".equals(className)))) {
                return (IPayment) Class.forName(className).newInstance();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    public IPayment create(Class<? extends IPayment> clazz) {
        try {
            if (null != clazz) {
                return clazz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
