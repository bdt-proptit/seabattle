package Tool;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Screen {
    public static void clear() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
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