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
package dojo.pattern.factory.normal;

import dojo.pattern.factory.AliPay;
import dojo.pattern.factory.IPay;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hthn
 * @create 2019-04-24
 * @since 1.0.0
 */
public class AliPayFactory implements PayFactory {

    @Override
    public IPay getPay() {
        return new AliPay();
    }
}
