package com.example.spring20230920.controller;

import com.example.spring20230920.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main8")
public class Controller8 {

    @RequestMapping("sub1")
    public void method1(Model model) {
        model.addAttribute("attr1","value1"); // attribute : model에 담긴 data(값) -- 속성값
        // attr1을 꺼내면 value1값
        model.addAttribute("attr2", "value2");

        // forward to /WEB-INF/jsp/main8/sub1.jsp
    }

    @RequestMapping("sub2")
    public void method2(Model model) {
        model.addAttribute("propone","😘");
        model.addAttribute("propTwo","😒");
    }

    @RequestMapping("sub33")
    public void method3(Person person, Model model) {
        person.setAge(22);
        model.addAttribute("nana", "강정");
        model.addAttribute("person", person); // person객체를 jsp에서 사용할 수 있게 추가
    }

    @RequestMapping("sub3")
    public void method3(Model model) {
        model.addAttribute("myName", "Jung");
        model.addAttribute("yourAddress", "seoul");
        model.addAttribute("herEmail", "abccc@naver.com");

        // view name : /main8/sub3
        // / WEB-INF/jsp/main8/sub3.jsp
    }
}
