package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao7;
import com.example.spring20230920.domain.MyDto41;
import com.example.spring20230920.domain.MyDto42;
import com.example.spring20230920.domain.MyDto43;
import com.example.spring20230920.domain.MyDto44;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("main37")
public class Controller37 {

    private final MyDao7 dao;

    /*
    axios.post("/main37/sub1", '{"name":"jones"}', {
        headers: {
            "content-type": "application/json"
        }
    })

    axios.post("/main37/sub1", {name: "jones"}) --  위 전체 코드와 같다.
    [ js(or java...) object -> json text 하는 과정을 serialize (직렬화)라고 한다 ]
    [ json text -> js(or java...) object 하는 과정은 parse (파싱)이라고 한다. ]
     */

    @PostMapping("sub1")
    public void method1(@RequestBody Map<String, Object> map) { // json쓸때 명시해야 하는 annotation
        System.out.println("map = " + map);

    }

    /*
    axios.post("/main37/sub2", {name: "lee", age: 33, score: 8.9})

    -> js object
    {name: "lee", age: 33, score: 8.9}
    -> json text
    '{"name": "lee", "age": 33, "score": 8.9}'
    -> java map
    {name="lee", age=33, score=8.9}
     */

    @PostMapping("sub2")
    public void method2(@RequestBody Map<String, Object> map) {
        System.out.println("map = " + map);
    }

    /*
    axios.put("/main37/sub3", {
            city: "seoul",
            name: "son",
            email: "son@gmail.com"})
     */
    @PutMapping("sub3")
    public void method3(@RequestBody Map<String, Object> map) {
        System.out.println("map = " + map);
    }

    // json 데이터 객체, 배열
    /*
    axios.post("/main37/sub4", {
            city: "paris",
            age: 30,
            married : true,
            car: null,
            home: {
                address: "seoul",
                price: 1000
            },
            foods: [
                "pizza",
                "burger",
                "부침개"
            ]
      }) --> java bean에서 city를 찾는다
     */
    @PostMapping("sub4")
    public void method4(@RequestBody MyDto42 dto) {
        System.out.println("dto = " + dto);

    }

    /*
    axios.post("/main37/sub5", {
            country: "japan",
            score: 58.2,
            skills: [
                "football",
                "soccer",
                "baseball"
            ],
            phone: "011-122-45"
            })
     */

    @PostMapping("sub5")
    public void method5(@RequestBody MyDto43 dto) {
        System.out.println("dto.getCountry() = " + dto.getCountry()); // String
        System.out.println("dto.getScore() = " + dto.getScore()); // Double
        System.out.println("dto.getSkills() = " + dto.getSkills()); // List<String>
        System.out.println("dto.getPhone() = " + dto.getPhone()); // String
    }
    
    /*
    axios.post("/main37/sub6", {
            name: "son",
            email: ["son@gmail.com", "hm@gmail.com"],
            home: {
                first: "seoul",
                second: "london"
                },
            price: 35.11,
            weight: 77.6,
            married: true
         })
     */


    @PostMapping("sub6")
    public void method6(@RequestBody MyDto44 dto) {
        System.out.println("dto.getName() = " + dto.getName());
        System.out.println("dto.getHome() = " + dto.getHome());
        System.out.println("dto.getWeight() = " + dto.getWeight());
        System.out.println("dto.getPrice() = " + dto.getPrice());
        System.out.println("dto.getEmail() = " + dto.getEmail());
        System.out.println("dto.getMarried = " + dto.getMarried());
    }

    /*
    axios.put("/main37/sub7", {
            id: 3,
            lastName: "kim",
            firstName: "min",
            birthDate: "2000-01-01"
            })
     */

    @PutMapping("sub7") // Put->update
    public void method7(@RequestBody MyDto41 dto) {
        int i = dao.updateEmployee(dto);
        System.out.println(dto.getId() + "번 직원 수정됨");
    }

}