package Tool;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Screen {
    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void delay(int second) throws InterruptedException {
        TimeUnit.SECONDS.sleep(second);
    }
    public static void countDown(int second) throws InterruptedException {
        while(second > 0){
            delay(1);
            System.out.print(second + " ");
            --second;
        }
        delay(1);
        System.out.println();
    }
}