package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao4;
import com.example.spring20230920.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("main30")
public class Controller30 {

    private final MyDao4 dao;

    @GetMapping("sub1")
    public void method1(Integer id) {
        String name = dao.select(id);
        System.out.println("name = " + name);
    }

    @GetMapping("sub2")
    public void method2(Double from, Double to) {
        List<String> names = dao.select1(from, to );
        names.forEach(System.out::println);
    }

    @GetMapping("sub3")
    public void method3(LocalDate from, LocalDate to) {
        List<String> list = dao.select2(from, to);
        list.forEach(System.out::println);
        System.out.println("list.size() = " + list.size());

        // from~to 에 주문된 상품명 출력 (상품명 정렬해서, 중복없이)
    }

    // /main30/sub4?min=1.00&max=80.00
    @GetMapping("sub4")
    public void method4(MyDto25 dto) {
        List<String> list = dao.select4(dto);
        System.out.println("list.size() = " + list.size());

    }

    // /main30/sub5?country1=germany&country2=france
    @GetMapping("sub5")
    public void method5(MyDto26 dto){
        // country1또는 country2에 사는 고객명들 출력
        List<String> list = dao.select5(dto);
        list.forEach(System.out::println);
    }

    // /main30/sub6?from=1996-09-01&to=1996-09-30
    @GetMapping("sub6")
    public void method6(MyDto27 dto1, MyDto28 dto2) {
        Integer num = dao.select6(dto1, dto2);
        System.out.println("num = " + num);
    }

    // /main30/sub7?page=2&rows=10&keyword=a
    @GetMapping("sub7")
    public void method7(MyDto29 dto1, MyDto30 dto2) {
        /*
        SELECT customerNAME
        FROM customers
        WHERE customerName LIKE '%a%'
        LIMIT 10, 10
//        */

        Integer page1 = dto1.getPage();
        Integer from = (page1-1)*dto1.getRows();
        dto1.setFrom(from);

        List<String> names = dao.select7(dto1, dto2);
        System.out.println(names);
    }

    // /main30/sub8?name=son&country=korea
    @GetMapping("sub8")
    public void method8(MyDto31 dto) {
        int row = dao.insert1(dto);
        System.out.println(row+"행이 입력");
    }

    @GetMapping("sub9")
    public void method9() {

    }

    @PostMapping("sub10")
    public void method10(MyDto32 emp) {
        int row = dao.insert2(emp);
        System.out.println(row + "행이 입력됨");
    }
}