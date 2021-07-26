package cn.wing.kid.hottr.controller;

import cn.wing.kid.hottr.data.HotterRepository;
import cn.wing.kid.hottr.model.Hotter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by WangSai on 2021/7/21
 */
@Controller
@RequestMapping(value = "/hotter")
public class HotterController {

    // 注入hotterRepository
    private final HotterRepository hotterRepository;

    @Autowired
    public HotterController(HotterRepository hotterRepository) {
        this.hotterRepository = hotterRepository;
    }

    /**
     * showRegistrationForm方法的@RequestMapping注解以及类级别的注解@RequestMapping组合起来，表明了这个方法会处理来自"/hotter/register"
     * 的get请求.
     *
     * @return 返回了一个名为"registerForm"的逻辑视图。根据之前在WebConfig中配置的ViewResolver.InternalResourceViewResolver
     * 中的配置，这个逻辑视图会导向到"/WEB-INF/views/registerForm.jsp"该界面。
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

    /**
     * 当处理注册表单的POST请求时，控制器需要接受表单数据并将表单数据保存为Hotter对象。
     * 控制器接受一个Hotter对象作为参数。这个对象有firstName、lastName、username和password属性，这些属性将会使用请求中同名的参数进行填充.
     * 最后，为了防止重复提交（用户点击浏览器的刷新按钮有可能会发生这种情况），应该将浏览器重定向到新创建用户的基本信息页面。
     *
     * @param hotter
     * @return 这里不仅返回了视图的名称供视图解析器查找目标视图，而且返回的值还带有重定向的格式。当InternalResourceViewResolver
     * 看到视图格式中的“redirect:”前缀 时，它就知道要将其解析为重定向的规则，而不是视图的名称。
     * 在本例中，它将会重定向到用户基本信息的页面。
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
            // 参数添加了@Valid注解, 这会告知Spring, 需要确保这个对象满足校验限制.
            // 添加校验限制并不能阻止表单提交, processRegistration()方法依然会被调用
            @Valid Hotter hotter,
            // 如果有校验出现错误的话，那么这些错误可以通过Errors对象进行访问.
            // 很重要一点需要注意，Errors参数要紧跟在带有@Valid注解的参数后 面，@Valid注解所标注的就是要检验的参 数。
            Errors errors) {
        // processRegistration()方法所做的第一件事就是调 用Errors.hasErrors()来检查是否有错误。 如果有错误的话，
        // Errors.hasErrors()将会返回到registerForm， 也就是注册表单的视图。这能够让用户的浏览器重新回到注册表单页 面，
        // 所以他们能够修正错误，然后重新尝试提交。
        if (errors.hasErrors()) {
            return "registerForm";
        }
        // hotterRepository 在HotterController的构造器中注入进来的。
        hotterRepository.save(hotter);
        return "redirect:/hotter/" + hotter.getUsername();
    }

    /**
     * @param username
     * @param model
     * @return
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showHotterProfile(@PathVariable String username, Model model) {
        Hotter hotter = hotterRepository.findByUsername(username);
        hotter.setEmail("dog.cool@gmail.com");
        model.addAttribute("hotter", hotter);
        return "profile";
    }
}
