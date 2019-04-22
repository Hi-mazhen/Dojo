/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: CoreApp
 * Author:   hthn
 * Date:     2019-04-19 18:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dojo.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hthn
 * @create 2019-04-19
 * @since 1.0.0
 */

@SpringBootApplication
public class CoreApp {

    public static void main(String[] args) {
        System.out.println("core");
        SpringApplication.run(CoreApp.class, args);
    }
}
