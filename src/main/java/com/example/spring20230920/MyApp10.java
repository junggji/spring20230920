package com.example.spring20230920;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class MyApp10 {
}

interface MyInterface1 {

}

@Component
class MyClass18 implements MyInterface1 {

}

@Component
class MyClass19 implements MyInterface1 {

}

@Component
//@RequiredArgsConstructor 주입될 수 있는 Bean이 여러개 일 경우 row30
class MyClass17 {
    private final MyInterface1 field;

    public MyClass17(@Qualifier("myClass18") MyInterface1 field) { // Qualifier로 사용할 Bean을 명시해줘야한다.
        this.field = field;
    }
}