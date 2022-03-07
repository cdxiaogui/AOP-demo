package com.syw.logtest.domain;

import lombok.Data;

@Data
public class A<T>{
    private int aa;
    private T tt;
    public static<T> A build(int aa, T t){
        A<T> a= new A<>();
        a.tt=t;
        return a;
    }
}
