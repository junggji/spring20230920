package com.example.spring20230920.service;

import com.example.spring20230920.dao.MyDao6;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // 실제업무를 하는 부분(controller -> service -> dao)
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class) // 하나의 업무annotation --> Service 에서
public class MyService1 {

    private final MyDao6 dao;

    public void tx1() {
        dao.update1();

        int c = 1/0; // runtimeException-> Exception발생시 Rollback!
                        //                  Exception없이 실행될 시 COMMIT!

        dao.update2();
    }
}
