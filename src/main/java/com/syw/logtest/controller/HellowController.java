package com.syw.logtest.controller;

import com.syw.logtest.aspect.ShopLevelLog;
import com.syw.logtest.domain.A;
import com.syw.logtest.domain.C;
import com.syw.logtest.domain.Request;
import com.syw.logtest.service.BussnissService;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HellowController {

    @Resource
    BussnissService bussnissService;



    @RequestMapping(value = "/ttt")
    public String tet(){

        bussnissService.log();
        System.out.println("controller======================");

        return "controller";
    }
    @RequestMapping(value = "/ssss")
    @ShopLevelLog
    public String tet2(){

        bussnissService.log();
        System.out.println("controller======================");

        return "controller";
    }

    @RequestMapping(value = "/333")

    public String tet3(){
        Request request = new Request();
        request.setJd(111L);
        request.setPin("jdpin");
        request.setAppId("test");
        test333(request);
        return "controller";
    }

    @ShopLevelLog
    public String test333(Request request){

        bussnissService.test3(request);
        System.out.println("controller======================");
        return "";
    }

    @RequestMapping(value = "/returnTypeB")
    @ShopLevelLog
    @ResponseBody
    public A<B> tet222(){
        bussnissService.log();
        System.out.println("controller======================");
        A<B> a =new A<>();
        a.setTt(new B());
        a.getTt().setBb(22);
        return a;

    }

    @RequestMapping(value = "/returnTypeBoolean")
    @ShopLevelLog
    public A<Boolean> tet223(){
        bussnissService.log();
        System.out.println("controller======================");
        A<Boolean> a =new A<>();
        a.setTt(Boolean.FALSE);
        return a;
    }
    @RequestMapping(value = "/returnTypeC")
    @ShopLevelLog
    public A<C<Boolean>> tet2234(){
        bussnissService.log();
        System.out.println("controller======================");
        A<C<Boolean>> a =new A<>();
        a.setTt(new C<Boolean>());
        return a;
    }

}

@Data
class B{
    private int bb;

}