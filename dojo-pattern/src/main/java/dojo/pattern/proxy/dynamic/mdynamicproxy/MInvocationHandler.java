/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: MInvocationHandler
 * Author:   mzh
 * Date:     2019/5/6 23:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dojo.pattern.proxy.dynamic.mdynamicproxy;

import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author mzh
 * @create 2019/5/6
 * @since 1.0.0
 */
public interface MInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args);
}
