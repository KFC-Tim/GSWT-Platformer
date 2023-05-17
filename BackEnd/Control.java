import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private String playerStatus = "standing";

    private int TIMER_DELAY = 1;
    private int jumps = 0;



    public Control() throws Exception {   init();
    }

    private void init() throws Exception {   gui = new GUI(this);
        player = new Player(this, gui.getGWindow());
        gui.gameWindow();
        isPlaying = true;

        SoundPlayer pl = new SoundPlayer("./BackEnd/back.wav");
        pl.play();

        playerStatus = "standing";

        new javax.swing.Timer(TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        }).start();


        //listFilesUsingFilesList("/");

        //playMusic("back.wav");

    }

    private void update()
    {   //TODO Collision-Detection
        if(playerStatus.equals("jumping"))
        {   jumps = 0;
            playerStatus = "jumping-up";

        }
        if(playerStatus.equals("jumping-up"))
        {   gui.setPlayerLocation(150, 650 -jumps);
            jumps+=10;
        }
        if(jumps >= 100)
        {   playerStatus = "jumping-down";
        }
        if(playerStatus.equals("jumping-down"))
        {   gui.setPlayerLocation(150, 650 - jumps);
            jumps-=10;
        }
        if(jumps == 0)
        {   playerStatus = "standing";
            jumps = -1;
        }

        if(playerStatus.equals("standing"))
        {   gui.setFrame("/Sprites/Male_idle.gif");
        }

        if(playerStatus.equals("walking"))
        {  gui.setFrame("/Sprites/Male_walk.gif");

        }
    }

    public void walkRight()
    {   System.out.println(playerStatus);
        if(!(playerStatus.equals("jumping-up") || playerStatus.equals("jumping-down"))) { playerStatus = "walking";};
    }

    public void standStill()
    {   if(!(playerStatus.equals("jumping-up") || playerStatus.equals("jumping-down"))) { playerStatus = "standing";};
    }

    public void jump() throws InterruptedException
    {   gui.setFrame("/Sprites/Male_jump.gif");
        if(!(playerStatus.equals("jumping-up") || playerStatus.equals("jumping-down") || playerStatus.equals("jumping")))
        {   playerStatus = "jumping";
        }
    }




    public static void main(String[] args) throws Exception {   Control c = new Control();
        //c.update();

    }

}