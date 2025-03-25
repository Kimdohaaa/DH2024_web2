package example.day12._스프링스케쥴링;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ScheduleService {

    // [1] 스케쥴링을 적용할 메소드 선언
    // @Scheduled(패턴) : 적용한 패턴에 따라 자동 실행되는 어노테이션

    @Scheduled(fixedRate = 3000) // (fixedRate = 밀리초) : 지정한 시간마다 실행
    public void task1(){
        System.out.println("TASK 1 작동" + LocalTime.now());
    }

    @Scheduled(fixedDelay = 5000) // (fixedDelay = 밀리초) : 지정한 시간마다 실행
    public void task2(){
        System.out.println("TASK 2 작동" + LocalTime.now());
    }

    @Scheduled(cron = "*/5 * * * * *") // (cron = "") : 지정한 시간마다 실행
    public void task3(){
        System.out.println("TASK 3 작동" + LocalTime.now());
    }
}
