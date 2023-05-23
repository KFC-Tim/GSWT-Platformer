

import javax.imageio.ImageIO;
import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class GUI
{   private Control ctrl;
    private JFrame gWindow;
    private URL sprite;
    private ImageIcon img;
    private Player player;
    //private Rect r;
    private Map tileMap;
    private ArrayList<Tile> tiles = new ArrayList<Tile>();

    private JPanel p;



    //////////////////////////////
    //////////////////////////////

    private Rectangle2D playerRect = new Rectangle2D.Double(100, 100, 10, 10);

    private TexturePaint playerTex;

    ///////////////////////////////
    ///////////////////////////////

    public GUI(Control c)
    {   ctrl = c;
        gWindow = new JFrame();
       try {
            player = new Player(350, 650, 150, 150, Sprite.toBuff("./out/production/GSWT-Platformer/Character1M_1_idle_0.png"));
            //r = new Rect(10, 10, 300,200, Sprite.toBuff("./Starter Tiles Platformer/DarkCastleTiles/DarkCastle_1_16x16.png"));
        } catch (IOException e) {
             //TODO Auto-generated catch block
            e.printStackTrace();
        }

        
    }

    public void gameWindow() throws IOException
    {   sprite = GUI.class.getResource("/Sprites/Male_idle.gif");
        
        
        //gWindow = new JFrame();
        gWindow.setSize(1800, 1000);
        gWindow.setTitle("GSWT-Platformer");
        gWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gWindow.setResizable(false);
        //gWindow.setLocation(null);
        
        //gWindow.add(r);
        gWindow.add(player);



        gWindow.setVisible(true);

    }




    public JFrame getGWindow()
    {   return gWindow;
    }

    public void reload()
    {   
        //tileMap.add(player);
        gWindow.remove(player);
        tileMap.repaint();
        gWindow.add(player);
        
        player.repaint();
        
        //r.repaint();
    
        gWindow.getContentPane().repaint();
        gWindow.repaint();
    }



    ///////////////////////////////////
    ///////////////////////////////////

    public void setPlayerSprite(BufferedImage s)
    {   player.setPlayerSprite(s);
        gWindow.repaint();
    }
    
    public Player getPlayer()
    {   return player;
    }
    
    public void addTileMap(Map tileMap)
    {   this.tileMap = tileMap;
        gWindow.add(tileMap);
    }

}