package example.day12._스레드풀;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example1 {
    // main 함수에는 main 스레드 (코드를 읽어들이는 역할) 가 내장됨 //
    public static void main(String[] args) {

        // [1] 반복문을 이용하여 반복문 횟수만큼 작업스레드를 생성하여 실행
        for(int i = 1; i <= 10; i++){
            // 1) 임의의 스레드명 선언
            String name = "thread" + i;

            // 2) 작업 스레드 생성 (익명체 사용)
            // 익명체 : Thread 스레드변수명 = new Thread(new 인터페이스명(){ 추상메소드구현코드 });
            Thread thread = new Thread(new Runnable() { // 작업스레드 선언 s
                @Override
                public void run() {
                    try {
                        System.out.println("작업스레드 : " + name + " 실행중"); // 순서가 계속 바뀜
                        Thread.sleep(1500); // 작업스레드 1.5 초 일시 정지
                    }catch (Exception e){
                        System.out.println(e);
                    }
                }
            }); // 작업스레드 선언 e

            // 3) 작업스레드 실행
            thread.start();
        }

        // 여러 작업스레드 간의 실행 순서는 보장되지 않음 //

        // [2] 스레드풀 : 반복문을 이용하여 반복문 횟수만큼 지정된 작업스레드에 배정하여 실행(미리 만들어진 스레드 관리)
        // 1) 스레드풀 생성 (고정된 스레드 개수 지정)
        // ExecutorService 스레드풀변수명 = Executors.newFixedThreadPool(개수);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 2) 반복문 실행
        for(int i = 1; i <= 10; i++){
            // 3) 임의의 스레드명 선언
            String name = "threadpool" + i;

            // 4) 새로운 스레드 생성이 아닌 스레드풀에 새로 정의한 스레드 등록
            // 스레드풀변수명.submit(new 인터페이스명(){ 추상메소드구현코드 });
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000); // 작업스레드 2 초 일시 정지
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    System.out.println("작업스레드 : " + name + " 실행중"); // 순서가 계속 바뀜
                }
            });
        }

        // 5) 스레드풀 종료
        // 스레드풀변수명.shutdown();
        executorService.shutdown();

        // [1] 번 한번에 10번 출력 [2] 번 한번에 3개씩 출력

    }
}
