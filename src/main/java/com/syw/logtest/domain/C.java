package com.syw.logtest.domain;

import lombok.Data;

@Data
public class C<T>{
    private int aa;
    private T tt;
    public static<T> C build(int aa, T t){
        C<T> a= new C<>();
        a.tt=t;
        return a;
    }
}