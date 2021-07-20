package cn.wing.kid.hottr.controller;

import cn.wing.kid.hottr.data.HottleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(method = RequestMethod.GET)
    public String hottles(Model model) {
        model.addAttribute("hottleList", this.hottleRepository.findHottles(Long.MAX_VALUE, 20));
        return "hottles";
    }
}
