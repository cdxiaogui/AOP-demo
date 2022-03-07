package com.syw.logtest;

import com.syw.logtest.service.BussnissService;
import javafx.application.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class Test {

    @Resource
    BussnissService bussnissService;

    @org.junit.jupiter.api.Test
    public void tests(){
        bussnissService.log();
        System.out.println("==============");
    }
}
