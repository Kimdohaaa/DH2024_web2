package web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// ★★★ 리액트와 통신 시 CORS 를 허용하기 위한 클래스 ★★★ //
@Configuration // 빈 등록
// WebMvcConfigurer 인터페이스를 implements
// => WebMvcConfigurer : Spring MVC 관련 설정값을 수정하는 인터페이스
public class CorsConfig implements WebMvcConfigurer {
    // CORS 관련 설정값 오버라이딩를 통해 수정
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 스프링 컨토롤러의 HTTP 매핑에 허용
                .allowedOrigins("http://localhost:5181") // 허용할 도메인(여러개 허용 가능 -> 쉼표로 구분)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메소드
                .allowedHeaders("*") // 허용할 HTTP Headers
                .allowCredentials(true); // HTTP 의 쿠키 , 인증 허용 => 세션 사용을 위해 지정
    }
}
