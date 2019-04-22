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
package dojo.pattern.factory;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hthn
 * @create 2019-04-22
 * @since 1.0.0
 */
public class SimpleFactory {


    public APay getPayObject (String payName) {

        if (payName == "ali") {
            return new AliPay();
        }

        if (payName == "wechat") {
            return new WechatPay();
        }

        if (payName == "union") {
            return new UnionPay();
        }
        return null;
    }
}
