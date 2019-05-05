/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: MatchmakingProxy
 * Author:   mzh
 * Date:     2019/5/5 21:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dojo.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author mzh
 * @create 2019/5/5
 * @since 1.0.0
 */
public class MatchmakingProxy {
    private Object target;

    public MatchmakingProxy(Object target) {
        this.target = target;
    }

    // 涉及类
    // static Object newProxyInstance(
    //  ClassLoader loader,  //指定当前目标对象使用类加载器
    //  Class<?>[] interfaces,    //目标对象实现的接口的类型
    //  InvocationHandler h      //事件处理器
    // )
    // //返回一个指定接口的代理类实例，该接口可以将方法调用指派到指定的调用处理程序。

    //  Object    invoke(Object proxy, Method method, Object[] args)
    // 在代理实例上处理方法调用并返回结果。

    public Object getProxyInstance () {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        before();
                        Object ret = method.invoke(target, args);
                        after();
                        return null;
                    }
                });
    }

    private void after() {
        System.out.println("成功了，有情人成眷属了，KPI也好看了");
    }

    private void before() {
        System.out.println("找目标群体，广告覆盖！！！！");
    }
}
