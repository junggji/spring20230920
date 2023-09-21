package com.example.spring20230920.domain;

public class Student {
    // email property (쓰기) -> get주석이므로
    // information property (읽기, 쓰기) -> get,set 메소드에서 이름변경
    private String email;
    private String info;


//    public String getEmail() {
//        return email;
//    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInformation() {
        return info;
    }

    public void setInformation(String info) {
        this.info = info;
    }
}
