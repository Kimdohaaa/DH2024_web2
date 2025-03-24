package example.day11.day11_task;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;


class Music extends  Thread{

    boolean musicsState = false;
    @Override
    public void run() {
        try {
            while (true) {
                if (musicsState) {
                    System.out.println("음악 재생 중...");
                    Thread.sleep(1000);
                } else {
                    break;                  }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


class  Web extends Thread{

    boolean webState = false;

    @Override
    public void run() {
        try {
            while (true) {
                if (webState) {
                    System.out.println("웹 서핑 중...");
                    Thread.sleep(1000);
                } else {

                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
public class Task {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Music music = new Music();
        Web web = new Web();

        System.out.println(" 1. 뮤직 ON/OFF | 2. 웹서핑 ON/OFF  0. 종료");
        while (true) {
            int choose = scan.nextInt();

            if(choose == 0){
                System.out.println("스마트폰 종료!");
                music.musicsState = false;
                web.webState = false;
                break;
            }else if(choose == 1){
                if (music.musicsState) {
                    music.musicsState = false;
                    System.out.println("음악 종료!");
                } else {
                    music.musicsState = true;
                    System.out.println("음악 시작!");
                    music.start();
                }
            }else if(choose == 2){
                if (web.webState) {
                   web.webState = false;
                   System.out.println("웹 서핑 종료!");
                } else {
                    web.webState = true;
                    System.out.println("웹 서핑 시작!");
                    web.start();
                }
            }


        }
    }
}
