package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto9;
import com.example.spring20230920.domain.MyDto7;
import com.example.spring20230920.domain.MyDto8;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Scanner;


@Controller
@RequestMapping("main9")
public class Controller09 {

    @RequestMapping("sub1")
    public void method1(Model model) {
        model.addAttribute("attr1", "son");
        model.addAttribute("attr2", 300);
        model.addAttribute("attr3", true);
        model.addAttribute("attr4", 3.14);

        // 모델속성이 배열일 경우
        model.addAttribute("attr5", new String[]{"lee", "kim"});

        String[] myArr1 = {"korea", "seoul", "jeju"};
        model.addAttribute("yourArr6", myArr1);

    }

    @RequestMapping("sub2")
    public void method2(Model model) {
        model.addAttribute("myName", new String[]{"Jung", "Kang"});
        model.addAttribute("yourEmail", new String[]{"na@naver.com", "go@gmail.com", "kim@naver.com"});
        model.addAttribute("herAddress", new String[]{"seoul", "london"});
    }

    @RequestMapping("sub3")
    public void method3(Model model) {
        model.addAttribute("names", List.of("두식", "봉석", "희수"));
        model.addAttribute("list1", List.of("one", "two", "three"));
        model.addAttribute("mapList1", List.of("1", "2", "3"));
        model.addAttribute("cities", List.of("seoul", "tokyo", "busan", "incheon"));

    }

    @RequestMapping("sub4")
    public void method4(Model model) {
        var map1 = Map.of("son", 7, "lee", 19, "kim", 30);
        var citmap = Map.of("seoul", "expensive", "busan", "far");
        var colmap = Map.of("red", 777, "blue", 123, "black", 999);
        model.addAttribute("myMap", map1);
        model.addAttribute("cityMap", citmap);
        model.addAttribute("color", colmap);

        // 띄어쓰기or특수기호는 jsp에서 ${map.my name}로 쓸수없다.
        var map3 = Map.of(
                "name", "두식",
                "my name", "봉석",
                "your-name", "희수"
        );
        model.addAttribute("attr3", map3);

    }

    @RequestMapping("sub5")
    public void method5(Model model) {
        var map1 = Map.of("phone1", "iphone", "phone2", "galaxy");
        var map2 = Map.of("korea", "seoul", "us", "ny");
        var map3 = Map.of("1st", "hamburger", "2nd", "pizza");


        model.addAttribute("phones", map1);
        model.addAttribute("caps", map2);
        model.addAttribute("foods", map3);

    }

    @RequestMapping("sub6")
    public void method6(Model model) {
        // 뭐든 넣을 수 있다~
        model.addAttribute("attr1", new Object());
        model.addAttribute("attr2", new Scanner(System.in));
        model.addAttribute("attr3", new MyDto7());
    }

    @RequestMapping("sub7")
    public void method7(Model model) {
        MyDto8 o1 = new MyDto8();
        o1.setFood("pizza");
        o1.setComputer("intel");
        o1.setBirthDate("2020-01-01");

        model.addAttribute("person1", o1);
    }

    @RequestMapping("sub8")
    public void method8(Model model) {
        MyDto9 o1 = new MyDto9();
        o1.setId(23L);
        o1.setFirstName("minsoo");
        o1.setLastName("Kim");
        o1.setClassName("pisick");
        o1.setPhoneNumber("010-1234-5678");

        model.addAttribute("student", o1);

    }

}


