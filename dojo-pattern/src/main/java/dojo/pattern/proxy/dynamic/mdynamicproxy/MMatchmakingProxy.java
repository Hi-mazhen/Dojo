/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: MMatchmakingProxy
 * Author:   mzh
 * Date:     2019/5/6 23:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dojo.pattern.proxy.dynamic.mdynamicproxy;

import dojo.pattern.proxy.IPerson;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author mzh
 * @create 2019/5/6
 * @since 1.0.0
 */
public class MMatchmakingProxy implements MInvocationHandler {
    private IPerson target;

    public Object getInstance (IPerson target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return MProxy.newProxyInstance(new MClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        before();
        Object ret = null;
        try {
            ret = method.invoke(this.target, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
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
