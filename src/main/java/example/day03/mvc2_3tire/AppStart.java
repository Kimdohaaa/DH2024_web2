package example.day03.mvc2_3tire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 현재 클래스와 동일 패키지 , 하위 클래스 들의 컴포넌트를 스캔
// 컴포넌트(모듈/레고조간) : MVC 패턴의 계층 클래스 들
// @Component 또는 포함된 @RestController 등의 어노테이션
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}
