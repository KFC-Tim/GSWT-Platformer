import javax.sound.sampled.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JLayer;


public class Control
{   private GUI gui;
    private Player player;
    private Boolean isPlaying;

    public Control() throws Exception {   init();
    }

    private void init() throws Exception {   gui = new GUI(this);
        player = new Player(this, gui.getGWindow());
        gui.gameWindow();
        isPlaying = true;

        SoundPlayer pl = new SoundPlayer();

        //listFilesUsingFilesList("/");

        playMusic("back.wav");

    }

    private void update()
    {   //things to do/check per cyclus
        //input handling

        while(isPlaying)
        {   //TODO Collision-Detection

        }
    }

    public void walkRight()
    {   gui.setFrame("/Sprites/Male_walk.gif");

    }

    public void standStill()
    {   gui.setFrame("/Sprites/Male_idle.gif");

    }


    private void playMusic(String s) throws Exception
    {

    }

    public Set<String> listFilesUsingFilesList(String dir) throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get(dir))) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        }
    }


    public static void main(String[] args) throws Exception {   Control c = new Control();
        c.update();

    }

}