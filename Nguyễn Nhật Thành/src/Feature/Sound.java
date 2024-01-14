package Feature;
import javax.sound.sampled.*;
import java.io.*;

public class Sound {
    static final String menuSoundPath = "src\\Documents\\menu.wav";
    static final String inGameSoundPath = "src\\Documents\\ingame.wav";
    static final String winSoundPath = "src\\Documents\\win.wav";
    static final String onButtonSoundPath = "src\\Documents\\onbutton.wav";
    static final String hitSoundPath = "src\\Documents\\hit.wav";
    static final String missSoundPath = "src\\Documents\\miss.wav";
    static final String finishTurnSoundPath= "src\\Documents\\finishturn.wav";
    static public boolean canPlay = true;
    public Sound(){}
    static File file = new File(menuSoundPath);
    static File buttonPath = new File(onButtonSoundPath);
    static AudioInputStream audioStream;
    static AudioInputStream button;
    static Clip clip;
    static Clip buttonSound;
    static public void stopSound(){ clip.close(); }
    static public void soundLoop(){ clip.loop(Clip.LOOP_CONTINUOUSLY); }
    static public void openGame() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        button = AudioSystem.getAudioInputStream(buttonPath);
        buttonSound = AudioSystem.getClip();
        buttonSound.open(button);

        clip = AudioSystem.getClip();
        audioStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioStream);
        soundLoop();
        clip.start();
    }
    static public void playMenuSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if(canPlay){
            if(!file.getPath().equals(menuSoundPath) || !clip.isOpen()){
                if(clip.isOpen()) clip.close();
                file = new File(menuSoundPath);
                audioStream = AudioSystem.getAudioInputStream(file);
                clip.open(audioStream);
                soundLoop();
                clip.start();
            }
        }
    }
    static public void playIngameSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if(canPlay){
            clip.close();
            file = new File(inGameSoundPath);
            audioStream = AudioSystem.getAudioInputStream(file);
            clip.open(audioStream);
            soundLoop();
            clip.start();
        }
    }
    static public void playWinSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if(canPlay){
            clip.close();
            file = new File(winSoundPath);
            audioStream = AudioSystem.getAudioInputStream(file);
            clip.open(audioStream);
            soundLoop();
            clip.start();
        }
    }
    static public void onButtonMenuSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if(canPlay){
            if(buttonSound.isOpen()){
                buttonSound.close();
                button = AudioSystem.getAudioInputStream(buttonPath);
                buttonSound.open(button);
                buttonSound.start();
            }
            else buttonSound.start();
        }
    }
    static public void playShotSound(boolean hit) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if(canPlay){
            File path;
            if(hit) path = new File(hitSoundPath);
            else path = new File(missSoundPath);
            AudioInputStream audio = AudioSystem.getAudioInputStream(path);
            Clip clip;
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        }
    }
    static public void finishTurnSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        if(canPlay){
            File path = new File(finishTurnSoundPath);
            AudioInputStream audio = AudioSystem.getAudioInputStream(path);
            Clip clip;
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        }
    }
}
