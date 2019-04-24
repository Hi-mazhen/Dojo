/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: AliPayFactory
 * Author:   hthn
 * Date:     2019-04-24 16:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dojo.pattern.factory.factorymethod;

import dojo.pattern.factory.AliPayment;
import dojo.pattern.factory.IPayment;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hthn
 * @create 2019-04-24
 * @since 1.0.0
 */
public class AliPayFactory implements IPayFactory {

    @Override
    public IPayment create() {
        return new AliPayment();
    }
}
