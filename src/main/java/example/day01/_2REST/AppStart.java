package example.day01._2REST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication 어노테이션
@SpringBootApplication
// @SpringBootApplication의 주요 어노테이션
// 1. @SpringBootConfiguration
// => @Configuration 어노테이션을 포함하며 Spring 컨테이너(메모리)에 bean(객체) 설정을 등록할 수 있도록 하는 어노테이션

// 2. @EnableAutoConfiguration
// => Spring boot 가 자동으로 필요한 bean(객체)을 설정
// => 웹 서버인 내장형 'tomcat' 을 설정하는 어노테이션

// 3. @ComponentScan
// => 현재 클래스 기준으로 동일한 패키지 및 하위 패키지를 자동으로 스캔하는 어노테이션
// ★ 스캔 대상 : Spring 컨테이너(메모리)에 등록할 대상 bean(객체)

// 스캔 어노테이션 : @Component @Controller @RestController @Service @Repository @Mapper 등 주로 MVC 어노테이션
public class AppStart {
    public static void main(String[] args) {
        // Spring 실행
        // -> SpringApplication.run(현재클래스명.class)
        // [1] Spring 컨테이너(메모리) 초기화
        // [2] 자동 설정 적용
        // [3] 내장형 웹서버(tomcat) 실행
        SpringApplication.run(AppStart.class);

    }
}
