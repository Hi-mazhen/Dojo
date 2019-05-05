/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: Farther
 * Author:   mzh
 * Date:     2019/5/5 20:47
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
public class Farther implements IPerson {
    private IPerson target;

    public Farther(IPerson target) {
        this.target = target;
    }

    @Override
    public void findLover() {
        before();
        target.findLover();
        after();
    }

    private void after() {
        System.out.println("看对眼了，张罗婚礼咯");
    }

    private void before() {
        System.out.println("打听周围的姑娘，牵线拉桥给介绍");
    }
}
