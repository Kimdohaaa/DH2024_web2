package example.day12._스프링스레드;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ThreadService {

    // [1] 비동기
    @Async // 메소드에 멀티스레드를 적용시키는 어노테이션
    public void thread1 (){
        System.out.println("ThreadService.thread1");

        String name = UUID.randomUUID().toString();

        for(int i = 1; i <= 10; i++){
            System.out.println(i + "번 작업스레드 : " + name );
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    } // 요청이 여러번 들어왔을 때 순서 없이 실행됨

    // [2] 동기화
    @Async // 메소드에 멀티스레드르 적용시키는 어노테이션
    public synchronized void thread2(){ // synchronized 키워드를 통해 동기화
        System.out.println("ThreadService.thread2");
        String name = UUID.randomUUID().toString();

        for(int i = 1; i <= 10; i++){
            System.out.println(i + "번 작업스레드 : " + name );
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    } // 요청이 여러번 들어왔을 때 각 요청이 순서대로 실행됨
}
