package cn.wing.kid.hottr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by WangSai on 2021/7/19
 */
@Controller // 声明为一个控制器
@RequestMapping({"/","/homepage"}) // 将控制器映射到"/"
public class HomeController {

    @RequestMapping(value="/", method=GET) // value属性指明，处理对"/"的get请求
    public String home() {
        // 视图名为home
        return "home";
    }

}