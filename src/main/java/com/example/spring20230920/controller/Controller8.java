package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main8")
public class Controller8 {

    @RequestMapping("sub1")
    public void method1(Model model) {
        model.addAttribute("attr1","value1"); // attribute : model에 담긴 data
        // attr1을 꺼내면 value1값
        model.addAttribute("attr2", "value2");

        // forward to /WEB-INF/jsp/main8/sub1.jsp
    }

    @RequestMapping("sub2")
    public void method2(Model model) {
        model.addAttribute("propone","😘");
        model.addAttribute("propTwo","😒");
    }
}
