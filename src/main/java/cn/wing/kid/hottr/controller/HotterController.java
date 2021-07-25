package cn.wing.kid.hottr.controller;

import cn.wing.kid.hottr.data.HotterRepository;
import cn.wing.kid.hottr.model.Hotter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
     * 接受一个Hotter对象作为参数。这个对象有firstName、lastName、username和password属性，这些属性将会使用请求中同名的参数进行填充。
     *
     * @param hotter
     * @return 这里不仅返回了视图的名称供视图解析器查找目标视图，而且返回的值还带有重定向的格式。当InternalResourceViewResolver
     * 看到视图格式中的“redirect:”前缀 时，它就知道要将其解析为重定向的规则，而不是视图的名称。
     * 在本例中，它将会重定向到用户基本信息的页面。
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(Hotter hotter) {
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
