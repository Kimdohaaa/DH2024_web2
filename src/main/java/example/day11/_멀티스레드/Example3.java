package example.day11._멀티스레드;

import java.time.LocalTime;
import java.util.Scanner;

// [1] 현재 시간을 출력하는 구현객체 //
class 시간클래스 implements Runnable{
    @Override
    public void run() { // implement 를 통해 받은 추상메소드를 구현
        try{
            while(true){
                // LocalTime.now() : 현재 시스템의 시간 반환 메소드
                System.out.println(LocalTime.now());

                Thread.sleep(1000); // 현재 스레드 1초 멈추기
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

// [2] 타이머를 출력하는 상속객체 //
class 타이머클래스 extends Thread{
    // 실행 여부를 판단할 boolean 변수 생성
    boolean state = true;

    @Override
    public void run() { // 상속을 통해 받은 run 메소드 오버라이딩
        int second = 0;
        try{
            while(state){
                // 1000 (1초) : 일시정지
                Thread.sleep(1000);
                second++;
                System.out.println(">> 타이머 : " + second + " 초");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    // 작업스레드는 run 메소드 종료 시 같이 종료됨 //
}
public class Example3 {
    public static void main(String[] args) {

        // [1] 현재 시간을 출력하는 스레드 생성 (시간클래스(작업스레드)) //

        // 1-1) 구현객체 생성
        시간클래스 runnable1 = new 시간클래스();
        Thread thread1 = new Thread(runnable1);

        // 1-2) 구현객체를 통한 스레드 실행
        thread1.start();

        // [2] 타이머를 출력하는 스레드 생성 (타이머클래스(작업스레드)) //
        // 2-1) 상속객체 생성
        타이머클래스 thread2 = new 타이머클래스();
        thread2.state = false;
        // 입력받기 (main 스레드) //
        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println(">> 타이머 1. ON 2. OFF");
            int ch =  scan.nextInt();

            if(ch == 1){
                System.out.println(">> 타이머 시작");
                thread2.state = true;
                // 2-2) 상속 객체를 통한 작업스레드 실행
                thread2.start();
                // 현재시간을 출력하는 작업스레드와 타이머를 출력하는 작업스레드가 동시에 각각 실행 //

            }else {
                System.out.println(">> 타이머 종료");
                // 타이머 클래스의 실행여부를 를 false 로 변경하여 while 문 종료
                thread2.state = false;
            }
        }

    }
}
