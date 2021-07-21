package cn.wing.kid.hottr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by WangSai on 2021/7/21
 */
@Controller
@RequestMapping(value = "/hotter")
public class HottlerController {

    /**
     * showRegistrationForm方法的@RequestMapping注解以及类级别的注解@RequestMapping组合起来，表明了这个方法会处理来自"/hotter/register"
     * 的get请求.
     *
     * @return 返回了一个名为"registerForm"的逻辑视图。根据之前在WebConfig中配置的ViewResolver.InternalResourceViewResolver
     * 中的配置，这个逻辑视图会导向到"/WEB-INF/views/registerForm.jsp"该界面。
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegister() {
        return "registerForm";
    }
}
