/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: StaticProxyTest
 * Author:   mzh
 * Date:     2019/5/5 20:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dojo.pattern.proxy.simple;

import dojo.pattern.proxy.IPerson;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author mzh
 * @create 2019/5/5
 * @since 1.0.0
 */
public class StaticProxyTest {
    // 三要素：
    // 接口类 IPerson
    // 目标对象 Son
    // 静态代理对象 Farther， 需要实现IPerson接口

    public static void main(String[] args) {
        // 目标对象
        Son target = new Son();
        // 代理对象
        Farther farther = new Farther(target);
        farther.findLover();
    }
}
