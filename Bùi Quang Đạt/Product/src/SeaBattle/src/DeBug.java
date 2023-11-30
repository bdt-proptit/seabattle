import java.io.*;
import java.util.Random;
import java.util.Queue;
import java.util.LinkedList;
import javax.sound.midi.*;
import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.*;
public class DeBug {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Scanner sc = new Scanner(System.in);
        Sound sound = new Sound();
        File Main_Theme = new File("Main Theme.wav");
        AudioInputStream audioStream_main = AudioSystem.getAudioInputStream(Main_Theme);
        Clip clip_main = AudioSystem.getClip();
        clip_main.open(audioStream_main);

        FloatControl volume2 = (FloatControl) clip_main.getControl(FloatControl.Type.MASTER_GAIN);
        // set the percent (between 0.0 and 1.0)
        double percent2 = 0.1;
        float dB2 = (float) (Math.log(percent2) / Math.log(10.0) * 20.0);
        volume2.setValue(dB2);
        clip_main.start();
        clip_main.loop(clip_main.LOOP_CONTINUOUSLY);
        String s = sc.next();
    }
    public static void slowPrint(int time, String toPrint){

        char[] toPrintC = toPrint.toCharArray();// Create a char array and assign that to a string converted to a char array
        for(int i = 0; i < toPrintC.length;i++){ // Create a for loop
            System.out.print(toPrintC[i]);// Print the char
            try{
                Thread.sleep(time);// Stop printing for the amount of milliseconds specified(in the variable time)
            }catch(Exception e){
                e.printStackTrace();
            }
            // We surround in try/catch because Thread.sleep throws an exception
        }
    }
}
