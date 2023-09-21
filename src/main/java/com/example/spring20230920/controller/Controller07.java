package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main7")
public class Controller07 {

    // (RequestMapping) Handler Method

    @RequestMapping("sub1")
    public String method1() { // return 타입이 String이면
        System.out.println("Controller07.method1");

        return "view1"; // view로 forward // application.properties에서 경로 설정
    }

    @RequestMapping("sub2")
    public String method2() {
        System.out.println("Controller07.method2");
        return "html2";
    }

    // void return : 요청경로가 view name이 됨
    // 요청경로 : /main7/sub3
    // view name : /main7/sub3
    // 실제 jsp 경로 : /WEB-INF/jsp/main7/sub3.jsp
    @RequestMapping("sub3")
    public void method3() {
        System.out.println("Controller07.method3");
    }

    @RequestMapping("sub4")
    public String method4() {
        System.out.println("Controller07.method4");
        return "/main7/html4";
    }

    @RequestMapping("sub5")
    public void method5() {
        System.out.println("Controller07.method5");
    }

}
