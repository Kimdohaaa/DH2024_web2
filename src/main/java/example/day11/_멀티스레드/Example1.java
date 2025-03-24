package example.day11._멀티스레드;

import java.awt.*;

public class Example1 {
    // [1] main 함수는 main 스레드를 포함하여 코드를 첫 시작함
    public static void main(String[] args) {

        // ============================== 싱글 스레드 ============================== //

        System.out.println(" (1) main 스레드가 읽어들이는 코드");

        // [2] main 함수 안에서 작성된 코드는 모드 main 스레드가 읽어들임
        for(int i = 1; i <= 5 ; i++){
            System.out.println(" (2) main 스레드가 읽어들이는 코드");
        }

        // [3-1] 비프음 5번 발생
        // Tookit 클래스 : Java UI(화면구현)를 제공하는 패키지로 소프트웨어 만들 때 주로 사용 (java.awt)
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i = 1; i <= 5; i++) {
            try {
                toolkit.beep(); // ToolKit 객체.beep() : 비프음을 발생시키는 메소드
                Thread.sleep(( 1000 )); // Thread.sleep(밀리초) : 스레드를 일시적으로 정지시킴 (예외처리필수)
            }catch (Exception e){
                System.out.println(e);
            }
        }
        // [3-2] "띵" 5번 출력
        for(int i = 1; i <= 5; i++) {
            try {
                System.out.println("띵");
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
        }
        // 싱글스레드 : 비프음과 출력이 따로 발생

        // ============================== 멀티 스레드(익명객체) ============================== //

        // [1] 비프음을 5번 발생 시키는 작업스레드 정의
        // // 1) 작업스레드 정의 => 익명객체 : implement 없이 추상메소드를 바로 구현
        Thread thread = new Thread(new Runnable() { // Runnable : 인터페이스
            @Override
            public void run() { // Runnable 인터페이스의 추상 메소드를 오버라이딩
                Toolkit toolkit1 = Toolkit.getDefaultToolkit();

                for(int i = 1;  i <= 5; i++){
                    toolkit1.beep();
                    try{
                        Thread.sleep(1000);
                    }catch (Exception e){
                        System.out.println(e);
                    }

                }
            }
        });
        // 2) 작업 스레드 실행
        thread.start();

        // [2] 출력을 5번 발생시키는 작업스레드 정의
        for(int i = 1;  i <= 5; i++){
            System.out.println("띵");
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
        }


        // ============================== 멀티 스레드(구현객체) ============================== //

        // [1] 구현 객체 생성 => 구현 객체 : implements 를 통해 구상메소드를 구현
        비프음1 비프음1 = new 비프음1();

        // 비프음을 5번 발생 시키는 작업스레드 정의
        Thread 비프음스레드1 = new Thread(비프음1);
        비프음스레드1.start();

        // 출력 5번을 발생 시키는 작업스레드 정의
        for(int i = 1;  i <= 5; i++){
            System.out.println("띵");
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
        }


        // ============================== 멀티 스레드(상속객체) ============================== //

        // [1] 상속 객체 생성 => 상속객체 : extends 를 통해 상속받은 메소드를 오버라이딩
        비프음2 비프음2 = new 비프음2();

        // 비프음을 5번 발생 시키는 작업스레드 정의
        비프음2.start();

        // 출력 5번을 발생 시키는 작업스레드 정의
        for(int i = 1;  i <= 5; i++){
            System.out.println("띵");
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
        }


        // 멀티스레드 : 비프음과 출력이 동시에 발생 (동시 작업가능 => 멀티 테스킹) //
    }
}
