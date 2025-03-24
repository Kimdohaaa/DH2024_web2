package example.day11._멀티스레드;
// *** User1 클래스 생성 (Thread 상속) *** //
class User1 extends Thread{
    public  Calculator calculator;

    @Override
    public void run() {
        calculator.setMemory(100);
    }
}

// *** User2 클래스 생성 (Thread 상속) *** //
class User2 extends Thread{
    public Calculator calculator;

    @Override
    public void run() {
        calculator.setMemory(200);
    }
}

// *** Calculator 클래스(계산기 클래스) 생성 *** //
class Calculator {
    public   int memory;


    public synchronized void setMemory(int memory){ // synchronized 키워드를 통해 동기 처리방법 1
        // synchronized(this) // synchronized 키워드를 통해 동기 처리방법 2
        this.memory = memory;
        try{
            Thread.sleep(2000); // 스레드 2초 일시정지
            // ★ 주의점 ★ 두개 이상의 스레드가 하나의 메소드 호출 시 비동기 처리가 됨
            // ★ 주의점 ★ 두개 이상의 스레드가 하나의 메소드를 순서대로 호출 시 동기 처리가 됨
            // -> 두개 이상의 스레드가 하나의 메소드를 요청하면 먼저 요청한 스레드가 종료될 때까지 다른 스레드는 대기상태
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(this.memory);
    }
}

public class Example4 {
    // *** 실행클래스 *** //
    public static void main(String[] args) {

         // [1] 계산기 객체 생성
         Calculator calculator = new Calculator();

         // [2] User1 과 User2 의 동일한 계산기 대입
         User1 user1 = new User1();
         user1.calculator = calculator;

         User2 user2 = new User2();
         user2.calculator = calculator;

         user1.calculator.memory = 100;
         System.out.println(user2.calculator.memory); // 100 출력 => user1과 user2 가 동일한 객체를 사용하기 때문

        // [3] 각 객체가 계산기에 대입 (비동기 처리 시)
        // user1.start(); // 200 출력
        // user2.start(); // 200 출력
        // 흐름 : A가 실행되면서 Calculator 클래스의 memory 를 100으로 변경
        //       -2초일시정지시작-> B가 실행되면서 Calculator 클래스의 memory 를 200으로 변경
        //       -2초일시정지종료-> user1 과 user2 모두 200 출력

        // [4] 각 객체가 계산기에 대입 (동기처리 시)
        user1.start(); // 100 출력
        user2.start(); // 200 출력
        // 흐름 : A가 실행되면서 Calculator 클래스의 memory 를 100 으로 변경 실행 (synchronized 키워드를 통해 대기) -> 변경완료
        //       -> B가 실행되면서 Calculator 클래스의 memory 를 200으로 변경 (synchronized 키워드를 통해 대기) -> 변경완료
    }
}
