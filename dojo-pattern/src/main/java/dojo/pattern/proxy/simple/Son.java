/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: Son
 * Author:   mzh
 * Date:     2019/5/5 20:43
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
public class Son implements IPerson {
    @Override
    public void findLover() {
        System.out.println("1.女的；2.白富美");
    }
}
