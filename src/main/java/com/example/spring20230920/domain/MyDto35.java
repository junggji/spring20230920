package com.example.spring20230920.domain;

import lombok.Data;
import lombok.Getter;

public class MyDto35 {
    private String id;

    @Getter
    private String uRL;

    // 프로퍼티명 : id  (get탈락시키고 앞글자를 소문자로)

    public String getId() {
        return id;
    }


}
