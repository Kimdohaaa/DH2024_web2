package example.day11._멀티스레드;

import java.awt.*;

// 구현객체 //
public class 비프음1 implements Runnable{
    @Override
    public void run() { // Runnable 인터페이스의 추상메소드 run 을 오버라이딩
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
}
