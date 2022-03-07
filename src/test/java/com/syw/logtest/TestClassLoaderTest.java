package com.syw.logtest;

import com.syw.logtest.service.ClassloaderBaseService;
import com.syw.logtest.service.impl.ClassloadtestImpl001;
import org.junit.Test;

import java.sql.Driver;
import java.util.ServiceLoader;

public class TestClassLoaderTest {
    @Test
    public void test001(){
//        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader().getParent());
        ServiceLoader<ClassloaderBaseService> services = ServiceLoader.load(ClassloaderBaseService.class);
        services.forEach((a) ->{
            System.out.println(a.test());
        });
//        System.out.println(ClassloadtestImpl001.class.getClassLoader());

        ServiceLoader<Driver> serviceDriver = ServiceLoader.load(Driver.class);
        serviceDriver.forEach((a) ->{
            System.out.println(a);
        });
    }

}
