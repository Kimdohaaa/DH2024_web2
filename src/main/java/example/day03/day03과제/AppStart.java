package example.day03.day03과제;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // SpringBoot 실행을 위한 관련 설정 주입
// @SpringBootApplication 이 주입된 AppStart 의 동일 패키지, 하위 패키지에만 @ComponentScan 이 적용되기 때문에 AppStart 위치 !주의!
public class AppStart {
    public static void main(String[] args) { // main 스레드 포함
        SpringApplication.run(AppStart.class); // main 스레드가 Spring 실행
    }
}
