package Main;
import Feature.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException, ClassNotFoundException {
        Sound.openGame();
        NewGame.startScreen();
    }
}