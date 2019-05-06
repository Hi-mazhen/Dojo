/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: MClassLoader
 * Author:   mzh
 * Date:     2019/5/6 23:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dojo.pattern.proxy.dynamic.mdynamicproxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈类加载〉
 *
 * @author mzh
 * @create 2019/5/6
 * @since 1.0.0
 */
public class MClassLoader extends ClassLoader {

    /**
     * 功能描述: 类加载，字节码转类<br>
     * 〈〉
     *

     * @return:
     * @since: 1.0.0
     * @Author:mzh
     * @Date: 2019/5/7 0:11
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        throw new ClassNotFoundException(name);
    }
}
