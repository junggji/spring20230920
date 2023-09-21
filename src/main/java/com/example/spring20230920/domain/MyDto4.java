package com.example.spring20230920.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data // = Getter,Setter,ToString
public class MyDto4 {
    // /main6/sub2?signed=true&email=ab@gmail.com&gender=male
    private Boolean signed;
    private String email;
    private String gender;
}
