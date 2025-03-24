package example.day11._멀티스레드;

import java.awt.*;

// 상속객체 //
public class 비프음2 extends  Thread{
    @Override
    public void run() { // 부모로부터 run 메소드를 상속받아 오버라이딩
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
