import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class SoundPlayer {


        Long currentFrame;
        Clip clip;
        String status;
        AudioInputStream audioInputStream;
        String filePath = "/back.wav";

    public SoundPlayer(String file) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {       filePath = file;
            System.out.println(filePath);
            audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
    }


    public void play()
    {   clip.start();
        status = "play";
    }

    public void pause()
    {   if (!status.equals("paused")) {
            this.currentFrame = this.clip.getMicrosecondLength();
            clip.stop();
            status = "paused";
        }

    }

    public void resumeAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {   if (!status.equals("play"))
        {   clip.stop();
            clip.close();
            resetAudioStream();
            currentFrame = 0L;
            clip.setMicrosecondPosition(0);
            this.play();
        }
    }

    public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {   currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {   audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
