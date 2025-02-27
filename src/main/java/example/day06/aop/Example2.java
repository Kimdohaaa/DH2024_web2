package example.day06.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// AOP //
// [1] 부가기능(온도체크) 만 작성한 클래스
@Aspect
@Component
class Security{

    @Before("execution( * TestService2.*(..))")
    // @Before : 지정한 메소드 실행 전에 어노테이션이 적용된 메소드 실행
    // execution : 실행
    // * : 모든 리턴 타입
    // 지정한 클래스 : TestService2 에서 실행
    // 지정한 메소드 : TestService2 의 모든 메소드 -> 와일드 카드를 통해 해당 클래스의 모든 메소드에서 실행
    // (..) : 모든 매개변수 타입
    // => TestService2 클래스의 모든 메소드들은 각 메소드가 *실행 전* 해당(securityCheck) 메소드가 *자동*실행
    public void securityCheck(){
        System.out.println("[코로나] 온도 체크 => 보안");
    }

    @After("execution( * example.day06.aop.TestService2.enter1(..))")
    // example.day06.aop.TestService2.enter1 메소드 *실행 후* 해당(securityCheck2) 메소드 *자동* 실행
    // 리턴타입 : * -> 모든 타입
    // 매개변수 타입 : (..) -> 모든 매개변수 타입
    public void securityCheck2(){
        System.out.println("함수 실행 종료");
    }

    // 매개변수가 있는 경우
    @Before("execution( * example.day06.aop.TestService2.enter3(..)) && args(name)")
        // enter3 메소드에서 name 매개변수를 가져옴
    public void securityCheck3(String name){
        // 매개변수를 가져와 로그처리 , 유효성검사 , 보안 , 트랜젝션을 위해
        System.out.println("<@Before> " + name + " 코로나 검사완료");
    }

    @AfterReturning(value = "execution ( * example.day06.aop.TestService2.enter3(..))", returning = "result")
        // 정상적으로 메소드 실행 시 enter3 메소드에서 리턴값을 가져와 securityCheck4 메소드에서 사용 가능
    public void securityCheck4(Object result){
        System.out.println("<@AfterReturning> " + result + " 이/가 결과값 정상");
    }

    // 메소드 실행 시간 체크 => 검증
    @Around("execution(* example.day06.aop.TestService2.enter3(..))")
    public Object timeCheck5(ProceedingJoinPoint joinPoint) throws Throwable{
        // ProceedingJoinPoint 인터페이스 : 지정한 메소드와 그 외 로직을 조합하여 구현하는 인터페이스
        //  -> 추가 로직에서 직접 지정한 메소드 호출 시 주로 사용 : 인터페이스변수명.proceed();
        //  -> 리턴값 받기 가능
        //  !!! 예외처리 필수 !!!

        // (1) 시작 시간
        long startTime = System.currentTimeMillis();

        // (2) 메소드 실행
        Object result = joinPoint.proceed(); // 지정된 메소드(enter3) 실행

        // (3) 종료 시간
        long endTime = System.currentTimeMillis();

        // System.currentTimeMillis() : 현재시간을 밀리초(1/1000초)로 반환

        // (4) 지정된 메소드의 실행 시간
        long timeMs = endTime - startTime;

        System.out.println("enter3 메소드의 실행 시간 : " + timeMs + "ms");

        // (5) 실행 시간 return
        return  result;

    }
}

// [2] Service : 부가기능(온도체크)를 제외하고 비즈니스 로직만 작성한 클래스
@Service
class TestService2 {
    // 메소드_1
    public  void enter1(){
        System.out.println("식당 입장");
    }

    // 메소드_2
    public void enter2(){
        System.out.println("학원 입장");
    }

    // 메소드_3 (매개변수가 있는 경우)
    public boolean enter3(String name){
        System.out.println("헬스장 입장");

        return true;
    }
}

// [3] Controller : HTTP 요청 / 응답
@RestController
class TestController{

    @Autowired
    TestService2 testService2;

    @GetMapping("/day06/aop")
    public void aop(){
        testService2.enter1();
        testService2.enter2();
        /*
        <출력>
        [코로나] 온도 체크 => 보안
        식당 입잗ㅇ
        [코로나] 온도 체크 => 보안
        학원입장
        */

        // service 실행 시 AOP 를 통해 부가 기능이 *자동*으로 호출됨
        // @Before 흐름 : AOP 가 적용된 공통 부가기능 -> Service 의 메소드
        // @After 흐름 : Service 의 메소드 -> AOP 가 적용된 공통 부가기능

        // 매개변수가 있는 경우
        testService2.enter3("강호동");
    }
}

// [4] Spring start
@SpringBootApplication
public class Example2 {
    public static void main(String[] args) {
        SpringApplication.run(Example2.class);
    }
}
