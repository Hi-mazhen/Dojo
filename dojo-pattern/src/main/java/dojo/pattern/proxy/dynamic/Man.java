/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: Man
 * Author:   mzh
 * Date:     2019/5/5 21:08
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
public class Man implements IPerson {
    @Override
    public void findLover() {
        System.out.println("白富美");
    }
}
