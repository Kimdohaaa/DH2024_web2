package example.day06._day06과제.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AopClass{

    @Before("execution(* example.day06._day06과제.controller.StudentController.*(..)) && args(..)")
    public static void beforeCheck(Object name, Object content){
        System.out.println("등록전 controller " +name + "실행");
        System.out.println("매개변수 : " + content);
    }

    @After("execution(* example.day06._day06과제.controller.StudentController.*(..)) && args(..)")
    public static void afterCheck(Object returnValue){
        System.out.println("등록후 controlelr  리턴값 : " + returnValue);
    }

    @Before("execution(* example.day06._day06과제.service.StudentService.*(..)) && args(..)")
    public static void beforeCheckService(Object name, Object content){
        System.out.println("등록전 Service" +name + "실행");
        System.out.println("매개변수 : " + content);
    }

    @After("execution(* example.day06._day06과제.service.StudentService.*(..)) && args(..)")
    public static void afterCheckService(Object returnValue){
        System.out.println("등록후 service 리턴값 : " + returnValue);
    }

    @Around("execution(* example.day06._day06과제.service.StudentService.*(..))")
    public static Object timeCheckService(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        // 실제 메소드 실행
        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        System.out.println("실행시간 service : " + (end - start) + "ms");

        return result;
    }

    @Around("execution(* example.day06._day06과제.controller.StudentController.*(..))")
    public  static Object timeCheckController(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        // 실제 메소드 실행
        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        System.out.println("실행시간 controller : " + (end - start) + "ms");

        return result;
    }
}