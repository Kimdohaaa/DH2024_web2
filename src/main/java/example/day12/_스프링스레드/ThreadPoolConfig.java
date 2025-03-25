package example.day12._스프링스레드;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

// 스프링에 내장된 스레드풀을 커스텀(재정의)하는 클래스 //
@Configuration // 설정 클래스 빈을 컨테이너에 등록하는 어노테이션
public class ThreadPoolConfig {

    // 스레드풀 커스텀 //
    // 1) 스레드풀을 커스텀할 메소드 선언
    @Bean // 해당 메소드를 스프링 컨테이너에 빈 등록하는 어노테이션
    public Executor taskExecutor(){
        // 2) 스레드풀 객체 선언
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // 3) 최소 실행 스레드 개수 설정
        executor.setCorePoolSize(1);

        // 4) 최대 실행 스레드 개수 설정
        executor.setMaxPoolSize(1);

        // 5) 대기 큐 개수 설정
        executor.setQueueCapacity(10); // 대기 상태가 초과될 시 503 상태코드가 발생

        // 6) 스레드 이름 설정
        executor.setThreadNamePrefix("");

        // 7) 스레드풀 초기화
        executor.initialize();

        // 8) 설정한 스레드풀 객체 반환
        return executor;
    }

}
