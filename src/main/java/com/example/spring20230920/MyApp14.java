package com.example.spring20230920;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class MyApp14 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp14.class, args);
        Object bean1 = context.getBean("myBean1");
        Object bean2 = context.getBean("myBean2");
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);

        Configuration1 conf = context.getBean("configuration1", Configuration1.class);
        MyClass27 obj1 = conf.myBean1(); // 재정의된 메소드 호출됨.. 따라서, new객체라도 같은 객체가 호출 (singleton pattern)
        MyClass27 obj2 = conf.myBean2();

        System.out.println("obj1 = " + obj1);
        System.out.println("obj2 = " + obj2);

        System.out.println(conf.myBean1());
        System.out.println(conf.myBean1());
        System.out.println(new MyClass27());
        System.out.println(new MyClass27());

        System.out.println("conf = " + conf);



    }
}

// Configuration 클래스(빈) :
// spring bean을 만드는 메소드를 가진 클래스
@Configuration
class Configuration1 {

    // 빈을 만드는 메소드
    // bean의 이름은 메소드명과 같음
    @Bean
    public MyClass27 myBean1() { // myBean1
        return new MyClass27(); // Singleton pattern
    }

    @Bean
    public MyClass27 myBean2() {
        return new MyClass27();
    }

}

// @Component // 빈의 이름이 클래스 이름을 lowerCamellCase로 바꾼 것
class MyClass27 {

}