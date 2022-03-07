package com.syw.logtest;

import com.syw.logtest.service.BussnissService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class LogtestApplicationTests {

    @Resource
    BussnissService bussnissServiceImpl;
    @Test
    public void contextLoads() {
        bussnissServiceImpl.log();
        System.out.println("=====================");
    }
    







}
