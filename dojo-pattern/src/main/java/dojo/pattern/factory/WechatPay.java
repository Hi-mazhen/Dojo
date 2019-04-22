/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: WechatPay
 * Author:   hthn
 * Date:     2019-04-22 21:04
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
public class WechatPay extends APay {
    @Override
    public String pay() {
        return "wechat pay";
    }
}
