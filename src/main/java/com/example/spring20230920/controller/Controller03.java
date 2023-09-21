package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("main2")
public class Controller03 {

    // /main2/sub1?address=seoul parameter name, parameter value
    @RequestMapping("sub1")
    public void method1(WebRequest request){ // request parameter : parameter (key값과 value쌍으로 이루어져있다)
        System.out.println("Controller03.method1");
        // url에 대한 설명
        // https://developer.mozilla.org/en-US/docs/Learn/Common_questions/Web_mechanics/What_is_a_URL

        String address = request.getParameter("address");
        System.out.println("address = " + address);
    }

    // /main2/sub2?name=son&address=london
    @RequestMapping("sub2")
    public void method2(WebRequest request) {
        String name = request.getParameter("name");
        String address = request.getParameter("address");

        System.out.println("name = " + name);
        System.out.println("address = " + address);
    }

    // /main2/sub3?name=son
    @RequestMapping("sub3")
    public void method3(@RequestParam("name") String name){ // 위에 작성코드와 같은역할
        System.out.println("name = " + name);
    }

    // /main2/sub4?name=son&address=london
    @RequestMapping("sub4")
    public void method4(@RequestParam("name") String name,
                        @RequestParam("address") String address) { // 여러가지 parameter 받을 수 있다
        System.out.println("name = " + name);
        System.out.println("address = " + address);
    }

    // /main2/sub5?email=son@naver.com&gender=male&number=010-8010-8981
    @RequestMapping("sub5")
    public void method5(@RequestParam("email") String email,
                        @RequestParam("gender") String gender,
                        @RequestParam("number") String number) {
        System.out.println("email = " + email);
        System.out.println("gender = " + gender);
        System.out.println("number = " + number);
    }

    @RequestMapping("sub6")
    public void method6(@RequestParam("name") String name,
                        @RequestParam("age") String age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        Integer a = Integer.valueOf(age);
    }

    @RequestMapping("sub7")
    public void method7(@RequestParam("name") String name,
                        @RequestParam("age") Integer age) { // 스프링이 바로 Integer로 변환
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }

    // /main2/sub8?address=seoul&married=false&age=66
    @RequestMapping("sub8")
    public void method8(@RequestParam("address") String address,
                        @RequestParam("married") Boolean married, // 참조타입이면 null값을 받을 수 있어서, 기본타입 null-> X
                        @RequestParam("age") Integer age) {
        System.out.println("address = " + address);
        System.out.println("married = " + married);
        System.out.println("age = " + age);
    }

    @RequestMapping("sub9")
    public void method9(@RequestParam(value = "name", required = false) String name){ // request parameter를 안써도 되게함
        System.out.println("name = " + name);
    }

    // /main2/sub10?address=seoul&age=30
    // /main2/sub10?address=jeju
    @RequestMapping("sub10")
    public void method10(@RequestParam ("address") String address,
                         @RequestParam (value = "age", required = false) String age) {
        System.out.println("address = " + address);
        System.out.println("age = " + age);
    }

    @RequestMapping("sub11")
    public void method11(@RequestParam (value = "age", defaultValue = "0") Integer age) {
        System.out.println("age = " + age);
    }



}
