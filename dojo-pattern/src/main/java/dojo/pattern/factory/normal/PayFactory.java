/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PayFactory
 * Author:   hthn
 * Date:     2019-04-24 16:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dojo.pattern.factory.normal;


import dojo.pattern.factory.IPay;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hthn
 * @create 2019-04-24
 * @since 1.0.0
 */
public interface PayFactory {
    IPay getPay();
}
