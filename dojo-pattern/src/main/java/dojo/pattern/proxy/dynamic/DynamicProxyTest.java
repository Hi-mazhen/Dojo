/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: DynamicProxyTest
 * Author:   mzh
 * Date:     2019/5/5 21:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dojo.pattern.proxy.dynamic;

import dojo.pattern.proxy.IPerson;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author mzh
 * @create 2019/5/5
 * @since 1.0.0
 */
public class DynamicProxyTest {
    // 运行时动态生成
    // 接口类 IPerson
    // 目标对象必须实现接口 Man
    // 代理对象MatchmakingProxy不需要实现接口,需要完成getProxyInstance


    public static void main(String[] args) {
        IPerson target = new Man();
        System.out.println(target.getClass());
        IPerson dProxy = (IPerson) new MatchmakingProxy(target).getProxyInstance();
        System.out.println(dProxy.getClass());
        dProxy.findLover();
    }
}
