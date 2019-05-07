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
import dojo.pattern.proxy.dynamic.mdynamicproxy.MMatchmakingProxy;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

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


    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, IOException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
        IPerson target = new Man();
        System.out.println(target.getClass());

        // IPerson dProxy = (IPerson) new MatchmakingProxy(target).getInstance();
        // System.out.println(dProxy.getClass());
        // dProxy.findLover();
        //
        // JDK 动态代理
        // IPerson jProxy = (IPerson) new MatchmakingJDKProxy().getInstance(target);
        // System.out.println(jProxy.getClass());
        // jProxy.findLover();
        // // 原理 jad 查
        // byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{IPerson.class});
        // try {
        //     FileOutputStream os = new FileOutputStream("D:\\Jad 1.5.8g\\$Proxy0.class");
        //     os.write(bytes);
        //     os.close();
        // } catch (FileNotFoundException e) {
        //     e.printStackTrace();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }


        IPerson mProxy = (IPerson) new MMatchmakingProxy().getInstance(target);
        System.out.println(mProxy.getClass());
        mProxy.findLover();


    }
}
