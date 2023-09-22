package com.example.spring20230920.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 모든 필드가진 생성자
@NoArgsConstructor  // 기본생성자
public class MyDto9 {
    private Long id;
    private String firstName;
    private String lastName;
    private String className;
    private String phoneNumber;

}
