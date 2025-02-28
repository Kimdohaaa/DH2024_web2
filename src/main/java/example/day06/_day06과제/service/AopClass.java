package example.day06._day06과제.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class AopClass{

    // @Before 과 @After 을 사용하지 않고 @Around 어노테이션 하나로 간소화
    @Around("execution(* example.day06._day06과제.service.StudentService.*(..))")
    public Object Check(ProceedingJoinPoint joinPoint) throws Throwable {
        // 실행됨 메소드명 출력
        System.out.println("실행함수 : " + joinPoint.getSignature());

        // 매개변수 출력
        System.out.println("매개변수 : " + Arrays.toString( joinPoint.getArgs()));

        // 지정한 메소드 실행
        Object result = joinPoint.proceed();

        // 리턴값 출력
        System.out.println("반환값 : " + result);

        return result;
    }
    /*
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

        // ProceedingJoinPoint
        System.out.println(joinPoint.getArgs()); // 지정된 메소드의 매개변수를 배열타입으로 반환
        System.out.println(joinPoint.getSignature()); // 지정된 메소드의 시그니처(매개변수/리턴타입/함수명) 반환
        System.out.println(joinPoint.getTarget()); // 지정한 메소드를 실행한 인스턴스 객체(현재는 StudentService) 반환

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
    */

}