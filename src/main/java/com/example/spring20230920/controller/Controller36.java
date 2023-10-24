package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao7;
import com.example.spring20230920.domain.MyDto39;
import com.example.spring20230920.domain.MyDto40;
import com.example.spring20230920.domain.MyDto41;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("main36")
public class Controller36 {

    private final MyDao7 dao;

    @GetMapping("sub1")
    public void method1() {

    }

    // /main36/sub2
    @GetMapping("sub2")
    public void method2(Integer id){
        Map<String, Objects> data = dao.selectByCustomerId(id);
        System.out.println("data = " + data);
    }

    // /main36/sub3?id=2
    @GetMapping("sub3")
    public void method3(Integer id) {
        Map<String, Objects> data = dao.selectByEmployeeId(id);
        System.out.println("data = " + data);
    }

    /* axios.post("/main36/sub4", {
            lastName: "son",
            firstName: "hm",
            birthDate: "2020-02-02"
            }, {
            headers:
            })

     */
    // post /main36/sub4
    // lastName=son&firstName=hm&birthDate=2020-02-02
    @PostMapping("sub4")
    public void method4(String lastName,
                        String firstName,
                        LocalDate birthDate) {
        dao.insertEmployee(lastName, firstName, birthDate);
    }

    // 브라우저 개발자도구 콘솔에 axios 코드 작성 후 실행
    /*
     axios.post("/main36/sub5", {
            name: "라면",
            price: 150.00,
            category: 3}, {
            headers: {
            "content-type": "application/x-www-form-urlencoded"
        }
            })
     */
    // post /main36/sub5
    // name=라면&price=150.00&category=3
    @PostMapping("sub5")
    public void method5(String name,
                        Double price,
                        Integer category) {
        int i = dao.inserProduct(name, price, category);
        System.out.println(i+"개 추가됨");
    }

    /*
    axios.delete("/main36/sub6")
     */
//    @RequestMapping(method= RequestMethod.DELETE, value = "sub6")
    @DeleteMapping("sub6") // 위의 코드와 같은일을 한다.
    public void method6() {
        System.out.println("Controller36.method6");

    }

    /*
    js 코드 작성 후 브라우저 콘솔에 실행
     */
    @DeleteMapping("sub7")
    public void method7() {
        System.out.println("Controller36.method7");
    }

    @DeleteMapping("sub8")
    public void method8(String name) {
        System.out.println("name = " + name);
    }

    /*
    axios.delete("/main36/sub8?name=son")
     */

    // PathVariable : 경로에 포함된 데이터
    /*
    axios.delete("/main36/sub9/son")
     */

    @DeleteMapping("sub9/{name}")
    public void method9(@PathVariable ("name") String n) {
        System.out.println("n = " + n);
    }

    /*
    axios.delete("/main36/sub10/3")
    axios.delete("/main36/sub10/5")
    axios.delete("/main36/sub10/7")
     */

    // delete /main36/sub10
    // 일하는 메소드 작성
    // 3,5,7은 메소드 아규먼트로 받아서 콘솔에 출력
    @DeleteMapping("sub10/{id}")
    public void method10(@PathVariable Integer iid) { // 이름같으면 생략 가능 (r 110과 비교)
        System.out.println("iid = " + iid);
    }

//    axios.delete("/main36/sub10/7")
    @DeleteMapping("sub11/{pid}")
    public void method11(@PathVariable Integer pid) {
        int c = dao.deleteBycrounctId(pid);
        System.out.println(c+"개");
    }

    // axios.delete("/main36/sub12/1")
    // axios.delete("/main36/sub12/3")
    // axios.delete("/main36/sub12/5")

    //1, 3, 5 고객 삭제되도록
    @DeleteMapping("sub12/{pid}")
    public void method12(@PathVariable Integer pid) {
        int c = dao.deleteByCustomer(pid);
        System.out.println(c+"개 삭제");
    }

    /*
    axios.put("/main36/sub13")
    put /main36/sub13
     */
//    @RequestMapping(method = RequestMethod.PUT, value = "sub13")
    @PutMapping("sub13")
    public void method13() {
        System.out.println("Controller36.method13");
    }

    /*
    axios.put("/main36/sub14", {
            name: "son",
            address: "korea"
            }, {
            headers: { "content-type": "application/x-www-form-urlencoded"
            }
            })
     */
    // put /main36/sub14
    // name=son&address=korea
    @PutMapping("sub14")
    public void method14(String name, String address) {
        System.out.println("name = " + name);
        System.out.println("address = " + address);
    }

    /*
    axios.put("/main36/sub15", {
            city: "seoul",
            age: 78,
            score: 3.14}, {
            headers: { "content-type": "application/x-www-form-urlencoded"
            }
            })
     */
    @PutMapping("sub15")
    public void method15(MyDto39 dto) {
        System.out.println("city = " + dto.getCity());
        System.out.println("age = " + dto.getAge());
        System.out.println("score = " + dto.getScore());
    }

    /*
    axios.put("/main36/sub16", {
            id: 30,
            name: "햄버거",
            category: 2,
            price: 500.00
            }, {
            headers: { "content-type": "application/x-www-form-urlencoded"
            }
            })
     */

    @PutMapping("sub16")
    public void method16(MyDto40 dto) {
        int rows = dao.updateProduct(dto);
        System.out.println(rows+"개 수정");
    }

    /*
    axios.put("/main36/sub17", {
            lastName: "lee",
            firstName: "kangin",
            birthDate: "2020-01-01",
            id: 5}, {
            headers: { "content-type": "application/x-www-form-urlencoded"
            }});
     */
    @PutMapping("sub17")
    public void method17(MyDto41 dto) {
        int rows = dao.updateEmployee(dto);
        System.out.println(rows+"개 수정");
    }
}
