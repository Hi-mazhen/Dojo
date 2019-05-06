/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: MProxy
 * Author:   mzh
 * Date:     2019/5/6 23:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dojo.pattern.proxy.dynamic.mdynamicproxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用来生成代码〉
 *
 * @author mzh
 * @create 2019/5/6
 * @since 1.0.0
 */
public class MProxy {
    /**
     * 功能描述: <br>
     * 〈〉
     *  1. 动态生成源代码，根据传入的 interfaces的方法数重写方法
     *  2. 输出源代码到磁盘
     *  3. 动态编译
     *  4. 加载类 MClassLoader

     * @return:
     * @since: 1.0.0
     * @Author:mzh
     * @Date: 2019/5/6 23:39
     */
    public static Object newProxyInstance(MClassLoader loader,
                                          Class<?>[] interfaces,
                                          MInvocationHandler h) {
        return null;
    }
}
