import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class SoundPlayer implements LineListener {

    public SoundPlayer() throws UnsupportedAudioFileException, LineUnavailableException, IOException {   super();
        playSound();
    }
    @Override
    public void update(LineEvent event) {
        if (LineEvent.Type.START == event.getType()) {
            System.out.println("Playback started.");
        } else if (LineEvent.Type.STOP == event.getType()) {
            //isPlaybackCompleted = true;
            System.out.println("Playback completed.");
        }
    }

    public void playSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("back.mp3");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);

        AudioFormat audioFormat = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);

        Clip audioClip = (Clip) AudioSystem.getLine(info);
        audioClip.addLineListener(this);
        audioClip.open(audioStream);
        audioClip.start();

        audioClip.close();
        audioStream.close();

        audioClip.loop(4);

        audioClip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
