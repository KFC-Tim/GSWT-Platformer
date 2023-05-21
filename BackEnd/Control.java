import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
    private KeyLis keylistener;
    private Boolean isPlaying;

    private BufferedImage playerSprite;

    private String playerStatus = "standing";

    private int TIMER_DELAY = 1;
    private int jumps = 0;

    private int t = 0;



    private Sprite standingSprite;
    private Sprite walkingSprite;
    private Sprite jumpSprite;


    public Control() throws Exception {   init();
    }

    private void init() throws Exception {   gui = new GUI(this);
        keylistener = new KeyLis(this);
        gui.gameWindow();
        isPlaying = true;

        SoundPlayer pl = new SoundPlayer("./BackEnd/back.wav");
        pl.play();

        /////////////////////////////
        ////////////////////////////

        standingSprite = new Sprite(8);
        for(int i=0; i<8; ++i)
        {   standingSprite.addSprite(i, Sprite.toBuff("./Clothes 1/Character1M_1_idle_" + i + ".png"));
        }

        walkingSprite = new Sprite(8);
        for(int i=0; i<8; ++i)
        {   walkingSprite.addSprite(i, Sprite.toBuff("./Clothes 1/Character1M_1_walk_" + i + ".png"));
        }

        jumpSprite = new Sprite(2);
        for(int i=0; i<2; ++i)
        {   jumpSprite.addSprite(i, Sprite.toBuff("./Clothes 1/Character1M_1_jump_" + i + ".png"));
        }


        ///////////////////////////
        ///////////////////////////

        playerStatus = "standing";

        new javax.swing.Timer(TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        }).start();

    }


    private void tick()
    {   /*TODO          1 | Abfrage Status
                        2 | Sprite Auswählen
                        3 | 
        */
        ++t;

        //Abfrage Status:
        
        switch(playerStatus)
        {   case "standing":    playerSprite = standingSprite.getSprite(t%8);
            case "walking":     playerSprite = walkingSprite.getSprite(t%8);
            case "jumping":     playerSprite = jumpSprite.getSprite(t%2);
        }

        gui.setPlayerSprite(playerSprite);
        gui.reload();

        System.out.println(t);

    }


    public void walkRight()
    {   System.out.println(playerStatus);
        if(!(playerStatus.equals("jumping-up") || playerStatus.equals("jumping-down"))) { playerStatus = "walking";};
    }

    public void standStill()
    {   if(!(playerStatus.equals("jumping-up") || playerStatus.equals("jumping-down"))) { playerStatus = "standing";};
    }

    public void jump() throws InterruptedException
    {   //gui.setFrame("/Sprites/Male_jump.gif");
        if(!(playerStatus.equals("jumping-up") || playerStatus.equals("jumping-down") || playerStatus.equals("jumping")))
        {   playerStatus = "jumping";
        }
    }




    public static void main(String[] args) throws Exception {   Control c = new Control();
        //c.update();

    }

}