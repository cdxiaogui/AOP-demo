package com.syw.logtest.service.impl;

import com.syw.logtest.domain.Request;
import com.syw.logtest.service.BussnissService;
import org.springframework.stereotype.Component;

@Component("logService")
public class BussnissServiceImpl implements BussnissService {
    @Override
    public void log() {
        System.out.println("执行业务11111");
    }

    @Override
    public void test2() {
        System.out.println("执行业务2222");
    }

    @Override
    public void test3(Request request) {

        System.out.println("执行业务2222" );
        System.out.println(request.toString() );
    }
}
