package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao3;
import com.example.spring20230920.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("main29")
public class Controller29 {

    private final MyDao3 dao3;

             // -------------- 하나의 열 하나의 행----------------
    @GetMapping("sub1")
    public void method1() {
        String name = dao3.select1();
        System.out.println("name = " + name);
    }

    @GetMapping("sub2")
    public void method2() {
        Double price = dao3.select2();

        System.out.println("price = " + price);
    }

    @GetMapping("sub3")
    public void method3() {
        // 1번 직원의 LastName 조회 후 출력
        String LastName = dao3.select3();

        System.out.println("LastName = " + LastName);
    }

    @GetMapping("sub4")
    public void method4() {
        // 2번 직원의 생일 조회 후 출력
        String Birth = dao3.select4();
        System.out.println("Birth = " + Birth);
    }

         // --------------하나의 열 여러행 ----------------

    @GetMapping("sub5")
    public void method5() {
        List<String> countrys = dao3.select5();

        countrys.forEach(System.out::println);
    }

    @GetMapping("sub6")
    public void method6() {
        // 직원들의 생일 조회
        List<LocalDate> births = dao3.select6();
        births.forEach(System.out::println);
    }

    @GetMapping("sub7")
    public void method7() {
        // 상품의 가격들 조회
        List<Double> priceList = dao3.select7();
        priceList.forEach(System.out::println);
    }

    // --------------하나의 행 여러열 ----------------

    @GetMapping("sub8")
    public void method8() {
        Map<String, Object> row = dao3.select8();
        System.out.println("row = " + row); // map에는 순서가 없다(보장되지 않는다)

    }

    @GetMapping("sub9")
    public void method9() {
        // 1번 상품의 상품명, 가격, 카테고리명
        Map<String, Object> produ = dao3.select9();
        System.out.println("produ = " + produ);

    }

    // javaBean으로 데이터 넘겨서 받기
    @GetMapping("sub10")
    public void method10() {
        MyDto19 dto = dao3.select10();
        System.out.println("dto = " + dto);
    }

    @GetMapping("sub11")
    public void method11() {
        MyDto20 dto = dao3.select11();
        System.out.println("dto = " + dto);

    }

    @GetMapping("sub12")
    public void method12() {
        MyDto21 dto = dao3.select12();
        // 2번 고객의 id, name, country
        // MyDto21 property는 (id, name, country)
        System.out.println("dto = " + dto);
    }

    // --------------여러행 여러열 (List<Map>----------------

    @GetMapping("sub13")
    public void method13() {
        List<Map<String, Object>> rows = dao3.select13();
        for (Map<String, Object> row : rows) {
            System.out.println("row = " + row);
        }
    }

    @GetMapping("sub14")
    public void method14() {
        // 1996년 7월 4일에 주문된 상품명, 상품의 수량, 상품의 가격
        List<Map<String, Object>> pros = dao3.select14();
        pros.forEach(System.out::println);
    }

    @GetMapping("sub15")
    public void method15() {
        // 1996년 7월 4일에 주문된 상품명, 상품의 수량, 상품의 가격
        List<MyDto22> pros = dao3.select15();
        pros.forEach(System.out::println);
    }

    // sub16 요청시
    // 1번 카테고리 상품들이 주문된 날짜, 상품명, 카테고리명, 수량, 가격
    // 날짜, 상품명 순으로 정렬
    @GetMapping("sub16")
    public void method16() {
        List<Map<String, Object>> prodetails = dao3.select16();
        prodetails.forEach(System.out::println);

    }

    @GetMapping("sub17")
    public void method17() {
        String s = dao3.select17();
        System.out.println("s = " + s);
        // 값이 없으면 null
    }

    @GetMapping("sub18")
    public void method18() {
        Integer s = dao3.select18(); // 참조타입(Integer)을 쓰면 null exception 방지
        System.out.println("s = " + s);
    }

    @GetMapping("sub19")
    public void method19() {
        MyDto24 dto = dao3.select19();
        System.out.println("dto = " + dto);
    }

    @GetMapping("sub20")
    public void method20() {
        MyDto24 dto = dao3.select20();
        System.out.println("dto = " + dto);
    }
}
