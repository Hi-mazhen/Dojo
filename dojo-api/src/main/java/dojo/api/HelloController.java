/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: HelloApi
 * Author:   hthn
 * Date:     2019-04-22 11:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dojo.api;

import dojo.core.hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hthn
 * @create 2019-04-22
 * @since 1.0.0
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private HelloService helloService;

    // try this in browser http://localhost:8080/hello/test
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String testControllerValidation(HttpServletRequest request, Model model){
        return "Hi, I'm " + helloService.getName();
    }

}
