import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import java.util.Scanner;
public class Sound {
    public void Wave() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("Waves Sound.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        // set the percent (between 0.0 and 1.0)
        double percent = 0.09;
        float dB = (float) (Math.log(percent) / Math.log(10.0) * 20.0);
        volume.setValue(dB);
        clip.start();
        clip.loop(clip.LOOP_CONTINUOUSLY);
//        String res = scanner.next();
    }
    public void Button()  throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File file = new File("Button Sound.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        // set the percent (between 0.0 and 1.0)
        double percent = 0.9;
        float dB = (float) (Math.log(percent) / Math.log(10.0) * 20.0);
        volume.setValue(dB);
        clip.start();
    }
    public void Bomb()  throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File file = new File("Bomb Sound.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        // set the percent (between 0.0 and 1.0)
        double percent = 0.99;
        float dB = (float) (Math.log(percent) / Math.log(10.0) * 20.0);
        volume.setValue(dB);
        clip.start();
    }
    public void Fight() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File file = new File("Fight Sound.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        // set the percent (between 0.0 and 1.0)
        double percent = 0.9;
        float dB = (float) (Math.log(percent) / Math.log(10.0) * 20.0);
        volume.setValue(dB);
        clip.start();
    }
    public void CountDown() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File file = new File("CountDown Sound.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        // set the percent (between 0.0 and 1.0)
        double percent = 0.9;
        float dB = (float) (Math.log(percent) / Math.log(10.0) * 20.0);
        volume.setValue(dB);
        clip.start();
    }
    public void StockFish() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File file = new File("StockFish Sound.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        // set the percent (between 0.0 and 1.0)
        double percent = 0.4;
        float dB = (float) (Math.log(percent) / Math.log(10.0) * 20.0);
        volume.setValue(dB);
        clip.start();
    }
    public void AlphaZero() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File file = new File("AlphaZero Sound.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        // set the percent (between 0.0 and 1.0)
        double percent = 0.7;
        float dB = (float) (Math.log(percent) / Math.log(10.0) * 20.0);
        volume.setValue(dB);
        clip.start();
    }
    public void Laugh() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File file = new File("Laugh Sound.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        // set the percent (between 0.0 and 1.0)
        double percent = 0.9;
        float dB = (float) (Math.log(percent) / Math.log(10.0) * 20.0);
        volume.setValue(dB);
        clip.start();
    }
    public void Brutality() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File file = new File("Brutality Sound.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        // set the percent (between 0.0 and 1.0)
        double percent = 0.9;
        float dB = (float) (Math.log(percent) / Math.log(10.0) * 20.0);
        volume.setValue(dB);
        clip.start();
    }
    public void Martin() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File file = new File("Martin Sound.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        // set the percent (between 0.0 and 1.0)
        double percent = 0.4;
        float dB = (float) (Math.log(percent) / Math.log(10.0) * 20.0);
        volume.setValue(dB);
        clip.start();
    }
    public void Wining() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File file = new File("Wining Sound.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        // set the percent (between 0.0 and 1.0)
        double percent = 0.4;
        float dB = (float) (Math.log(percent) / Math.log(10.0) * 20.0);
        volume.setValue(dB);
        clip.start();
        File file2 = new File("Victory Sound.wav");
        AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
        Clip clip2 = AudioSystem.getClip();
        clip2.open(audioStream2);

        FloatControl volume2 = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
        // set the percent (between 0.0 and 1.0)
        double percent2 = 0.9;
        float dB2 = (float) (Math.log(percent2) / Math.log(10.0) * 20.0);
        volume2.setValue(dB2);
        clip2.start();
    }
    public void Losing() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File file = new File("Losing Sound.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        // set the percent (between 0.0 and 1.0)
        double percent = 0.2;
        float dB = (float) (Math.log(percent) / Math.log(10.0) * 20.0);
        volume.setValue(dB);
        clip.start();
        File file2 = new File("Test Your Luck.wav");
        AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
        Clip clip2 = AudioSystem.getClip();
        clip2.open(audioStream2);

        FloatControl volume2 = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
        // set the percent (between 0.0 and 1.0)
        double percent2 = 0.9;
        float dB2 = (float) (Math.log(percent2) / Math.log(10.0) * 20.0);
        volume2.setValue(dB2);
        clip2.start();
    }
}
