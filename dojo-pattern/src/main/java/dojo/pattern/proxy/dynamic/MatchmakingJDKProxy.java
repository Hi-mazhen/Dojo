/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: MatchmakingJDKProxy
 * Author:   mzh
 * Date:     2019/5/6 20:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dojo.pattern.proxy.dynamic;

import dojo.pattern.proxy.IPerson;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author mzh
 * @create 2019/5/6
 * @since 1.0.0
 */
public class MatchmakingJDKProxy implements InvocationHandler {
    private IPerson target;

    public Object getInstance (IPerson target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Method in:interfaces[0].getMethods()) {
            System.out.println(in.getName());
        }

        return Proxy.newProxyInstance(clazz.getClassLoader(), interfaces, this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object ret = method.invoke(this.target, args);
        after();
        return ret;
    }

    private void after() {
        System.out.println("成功了，有情人成眷属了，KPI也好看了");
    }

    private void before() {
        System.out.println("找目标群体，广告覆盖！！！！");
    }
}
