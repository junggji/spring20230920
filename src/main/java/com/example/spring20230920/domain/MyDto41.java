package com.example.spring20230920.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MyDto41 {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Integer id;
}
