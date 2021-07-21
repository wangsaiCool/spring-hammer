package cn.wing.kid.hottr.controller;

import cn.wing.kid.hottr.data.Hottle;
import cn.wing.kid.hottr.data.HottleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by WangSai on 2021/7/20
 */
@Controller
@RequestMapping("/hottles")
public class HottleController {

    private HottleRepository hottleRepository;

    @Autowired
    public HottleController(HottleRepository hottleRepository) {
        this.hottleRepository = hottleRepository;
    }
//
//    /**
//     * 我们在hottles()方法中给定了一个Model作为参数。这样，hottles()方法就能将Repository中获取到的Hottle列表填充到模型中。
//     * Model实际上就是一个Map（也就是key-value对的集合），它会传递给视图，这样数据就能渲染到客户端了。当调用addAttribute()方法，
//     * 并且不指定key的时候，那么key会根据值的对象类型推断确定。在本例中，因为它是一个List<Spittle>，因此，键将会推断为hottleList。
//     *
//     * @return 返回hottles作为视图的名字， 这个视图会渲染模型。
//     */
//    @RequestMapping(method = RequestMethod.GET)
//    public String hottles(Model model) {
//        model.addAttribute("hottleList", this.hottleRepository.findHottles(Long.MAX_VALUE, 20));
//        return "hottles";
//    }

    /**
     * 处理查询参数.(比如 "/hottles?max=238900&count=50")
     * <p>
     * 这个版本与上面的版本有些差别。它并没有返回视图名称，也没有显式地设定模型，这个方法返回的是Hottle列表。当处理器方法像
     * 这样返回对象或集合时，这个值会放到模型中，模型的key会根据其类型推断得出（在本例中，也就是hottleList）。而逻辑视图的
     * 名称将会根据请求路径推断得出。因为这个方法处理针 对“/hottles”的GET请求，因此视图的名称将会是hottles（去掉开头的斜线）。
     * <p>
     * 不管你选择哪种方式来编写spittles()方法，所达成的结果都是相同 的。模型中会存储一个Spittle列表，key为spittleList，
     * 然后这个 列表会发送到名为spittles的视图中。按照我们配 置InternalResourceViewResolver的方式，视图的JSP将会是
     * “/WEB- INF/views/spittles.jsp”。
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Hottle> hottles(
            // 如果max参数没有指定，那么就会使用默认的设置。由于查询参数是String类型的，因此defaultValue属性值也需要设置为String类型
            // defaultValue的属性为String类型，当运行到函数时，将会根据函数的参数类型进行转换
            @RequestParam(value = "max", defaultValue = Long.MAX_VALUE + "") long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return hottleRepository.findHottles(max, count);
    }

    /**
     * 通过路径传入参数.
     * <p>
     * 这里使用了@PathVariable("hottleId")注解，表明请求中占位符位置的值都会被传送到处理器方法的hottleId参数。@RequestMapping中value属性的
     * 占位符必须和@PathVariable包裹的参数一致。如果@PathVariable中没有给定参数， 那么将默认使用入参的册数参数名。
     *
     * @return
     */
    @RequestMapping(value = "/show/{hottleId}", method = RequestMethod.GET)
    public String hottles(@PathVariable long hottleId, Model model) {
        model.addAttribute("hottle", hottleRepository.findOne(hottleId));
        return "hottle";
    }

}
