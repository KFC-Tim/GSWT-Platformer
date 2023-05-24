

import javax.sound.sampled.*;

import java.awt.Color;
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
    private Player player;
    private Map tileMap;

    private BufferedImage playerSprite;

    private String playerStatus = "standing";

    private int TIMER_DELAY = 1;
    private int jumps = 0;

    private int t = 0;
    private int spriteUpdate = 0;

    private int t0;
    private int y0;
    private Boolean isJumping;
    private Boolean isFalling;
    private int fall;



    private Sprite standingSprite;
    private Sprite walkingSprite;
    private Sprite jumpSprite, fallSprite;


    public Control() throws Exception {   init();
    }

    private void init() throws Exception {   
        gui = new GUI(this);
        keylistener = new KeyLis(this);
        gui.getGWindow().addKeyListener(keylistener);
        gui.gameWindow();
        isPlaying = true;

        SoundPlayer pl = new SoundPlayer("./out/production/GSWT-Platformer/back.wav");
        pl.play();

        Player pla = gui.getPlayer();
        player = pla;
        //player = new Player(spriteUpdate, y0, jumps, TIMER_DELAY, Sprite.toBuff("./out/production/GSWT-Platformer/Character1M_1_idle_0.png"));

        tileMap = new Map(16, 28, gui.getGWindow().getSize());
        tileMap.loadMap();
        gui.addTileMap(tileMap);
        showHitBox();

        /////////////////////////////
        ////////////////////////////

        standingSprite = new Sprite(8);
        for(int i=0; i<8; ++i)
        {   standingSprite.addSprite(i, Sprite.toBuff("./out/production/GSWT-Platformer/Character1M_1_idle_" + i + ".png"));
        }

        walkingSprite = new Sprite(8);
        for(int i=0; i<8; ++i)
        {   walkingSprite.addSprite(i, Sprite.toBuff("./out/production/GSWT-Platformer/Character1M_1_walk_" + i + ".png"));
        }

        jumpSprite = new Sprite(2);
        for(int i=0; i<2; ++i)
        {   jumpSprite.addSprite(i, Sprite.toBuff("./out/production/GSWT-Platformer/Character1M_1_jump_" + i + ".png"));
        }

        fallSprite = new Sprite(2);
        for(int i=0; i<2; ++i)
        {   fallSprite.addSprite(i, Sprite.toBuff("./out/production/GSWT-Platformer/Character1M_1_fall_" + i + ".png"));
        }


        ///////////////////////////
        ///////////////////////////

        playerStatus = "standing";
        isJumping = false;
        isFalling = false;

        new javax.swing.Timer(TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        }).start();

    }


    private void tick()
    {    ++t;
        if(t%3 == 0)
        {   ++spriteUpdate;
            gui.reload();
        }

        

        //Abfrage Status:
        if(!isJumping && !isFalling)
        {   switch(playerStatus)
            {   case "standing":    playerSprite = standingSprite.getSprite((spriteUpdate/2)%8);
                                    
                                    break;
                case "walking":     playerSprite = walkingSprite.getSprite((spriteUpdate/2)%8);
                                    player.setX(player.getX0() + 1);
                                    break;
                case "jumping":     playerSprite = jumpSprite.getSprite((spriteUpdate/2)%2);
                                    t0 = spriteUpdate;
                                    y0 = player.getY0();
                                    isJumping = true;
                                    jumping();
            }

            if(player.getX0()%32 == 0)
            {
                fall = HitBox.fallsTo(player);
                if(player.getY0()!=fall)
                {   playerStatus = "falling";
                    isFalling = true;         
                }
            }
        }
        else if(isJumping)
        {   playerSprite = jumpSprite.getSprite((spriteUpdate/2)%2);
            jumping();
        }
        else if(isFalling)
        {   playerSprite = fallSprite.getSprite((spriteUpdate/2)%2);
            fallTo(fall);
        }
        
        if(player.getY0()>850)
        {   fallOutMap();
            fall = HitBox.fallsTo(player);
            isFalling = true;
        }

        gui.setPlayerSprite(playerSprite);
        gui.reload();

        


    }

    private void jumping()
    {   int x = spriteUpdate - t0;
        
        player.setY(y0 + (int) (4*(x*(x-7))));

        if(x>=7)
        {   isJumping = false;

        }
    } 


    public void walkRight()
    {  playerStatus = "walking";
    }

    public void standStill()
    {   playerStatus = "standing";
    }

    public void jump() throws InterruptedException
    {   //gui.setFrame("/Sprites/Male_jump.gif");
        playerStatus = "jumping";
        
    }

    public void fallTo(int f)
    {   int posY = player.getY0();
        int diffY = f - posY;

        if(diffY>15)
        {   player.setY(posY+10 + (10/(diffY*diffY*diffY)));
        }
        else
        {   player.setY(fall);
            isFalling = false;
            playerStatus = "standing";
        }

        System.out.println(fall);
    }

    private void fallOutMap()
    {   player.setX(player.getX0()-32);

        //player.setX(0);
        player.setY(0);

    }


    private void showHitBox()
    {   HitBox[] h = HitBox.getHitboxes1D();
        Color c = new Color(255, 0, 0);

        for(int i=0; i<h.length; ++i)
        {   
            if(h[i]!=null){gui.showJPanel(h[i].showHitBox(), c);}
        }

    }


    public static void main(String[] args) throws Exception {   Control c = new Control();
        //c.update();

    }

}