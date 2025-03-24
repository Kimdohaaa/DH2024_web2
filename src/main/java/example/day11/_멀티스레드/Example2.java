package example.day11._멀티스레드;

// [1] 상속 객체
class 작업스레드A extends Thread{
    @Override
    public void run() { // 상속받아 메소드를 오버라이딩
        try{
            int count = 1;
            while (true){
                // Thread.sleep(밀리초) : 해당 스레드가 밀리초만큼 일시정지 (!!!예외처리필수!!!)
                Thread.sleep(1000);
                // Thread.currentThread().setName("작업스레드명") : 해당 스레드의 이름 정의
                Thread.currentThread().setName("작업스레드A");
                count++;

                // Thread.currentThread().getName() : 현재 스레드명 가져오기
                System.out.println("현재 스레드명 : " + Thread.currentThread().getName());
                System.out.println("count : " + count);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
public class Example2 {
    // [1] main 스레드 생성
    public static void main(String[] args) {
        // [2] 작업 스레드 생성

        // [2-1] 상속객체를 통한 작업스레드 생성
        // 1) 메인스레드가 작업스레드 생성
        작업스레드A thread1 = new 작업스레드A();
        // 2) 메인스레드가 작업스레드 실행
        thread1.start(); // run 메소드 실행

        // 3) 메인스레드가 메인스레드 내 코드 실행
        int count = 1;
        while(true) {
            try {
                // Thread.sleep(밀리초) : 해당 스레드가 밀리초만큼 일시정지 (!!!예외처리필수!!!)
                Thread.sleep(1000);

                count++;

                // Thread.currentThread().getName() : 현재 스레드명 가져오기
                System.out.println("현재 스레드명 : " + Thread.currentThread().getName());
                System.out.println("count : " + count);
            }catch (Exception e){
                System.out.println(e);
            }
        }
        // => 메인스레드와 작업스레드 동시 실행 (병렬처리)

        // 흐름 : 메인스레드 생성 -> 메인스레드가 작업스레드A 객체 생성 -> 메인스레드가 작업스레드A 실행 -> 메인스레드가 코드 실행

        // [2-2]
        // [2-3]
    }
}
