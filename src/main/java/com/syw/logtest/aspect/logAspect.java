package com.syw.logtest.aspect;

import com.syw.logtest.domain.A;
import com.syw.logtest.domain.Request;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

@Aspect
@Component
public class logAspect {

    /**
     * 切入点
     */
    @Pointcut("execution(* com.syw.logtest.service.impl.*.*(..))")
    public void pointCut() {
    }



    /**
     * 通知方法
     *
     */
    @Before("pointCut()")
    public void addLogBefore(JoinPoint joinPoint) {
        try {
            System.out.println("111执行前  业务处理 ");
            Arrays.stream(joinPoint.getArgs()).forEach(System.out::println);
//            pj.proceed();
            System.out.println("111执行前  业务处理 完成");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Around("pointCut()")
    public void addLog(ProceedingJoinPoint pj) {
        try {
            System.out.println("执行前为");
            pj.proceed();
            System.out.println("执行后为");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    /**
     * 第二种  切入点
     */
    @Pointcut("@annotation(com.syw.logtest.aspect.ShopLevelLog)")
    public void pointCut2() {
    }

    /**
     * 通知方法
     *
     * @param pj
     */
    @Around("pointCut2()")
    public Object addLog2(ProceedingJoinPoint pj) {
        try {

            Object objs = getParameterizedType(pj);
            if(objs != null ) return objs;
            System.out.println("执行前为222222222222");
            for (Object obj : pj.getArgs()) {
                if (obj instanceof Request) {
                    System.out.println("1");
                    System.out.println(((Request) obj).getAppId());
                }
                System.out.println("2");
                System.out.println(obj);
            }
            pj.proceed();
            System.out.println("执行后为222222222222");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "testsss";

    }

    private void testsss(ProceedingJoinPoint joinPoint) {


        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();

    }
    private static Object getParameterizedType(ProceedingJoinPoint pjp){
        Method method = ((MethodSignature)pjp.getSignature()).getMethod();
        Type type = method.getGenericReturnType();    //判断是否带有泛型
        if (type instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            //获取泛型类型
            // 如果还是泛型 不在处理
            if(actualTypeArguments[0] instanceof ParameterizedType){
                return A.build(333,null);
            }else {
                String className = ((Class) actualTypeArguments[0]).getCanonicalName();
                // 目前处理单个单层泛型的
                if(className.equals(Boolean.class.getCanonicalName())){
                    return A.build(111,Boolean.FALSE);
                }else if(className.equals(String.class.getCanonicalName())){
                    return A.build(111,"");
                }
            }

        }
        return A.build(333,null);
    }

}

