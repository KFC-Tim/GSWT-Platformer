import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

import javax.imageio.IIOException;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Test
{   private static JFrame gui;
    private static Rect r;
    private static Player p;

    private static Tile t;
    private static Tile t2;

    private static Map tileMap;

    private static AlphaComposite ac;

    public static void main(String[] args)
    {   
        /* 
        try {
            //t = new Tile(10, 10, Sprite.toBuff("./Starter Tiles Platformer/DarkCastleTiles/DarkCastle_1_16x16.png"));
            t2 = new Tile(20, 20, Sprite.toBuff("./Starter Tiles Platformer/DarkCastleTiles/DarkCastle_1_16x16.png"));
            
            //tileMap.addTile(1, 1, Sprite.toBuff("./Starter Tiles Platformer/DarkCastleTiles/DarkCastle_1_16x16.png"));
            //tileMap.addTile(1, 2, Sprite.toBuff("./Starter Tiles Platformer/DarkCastleTiles/DarkCastle_1_16x16.png"));
            //tileMap.addTile(1, 3, Sprite.toBuff("./Starter Tiles Platformer/DarkCastleTiles/DarkCastle_1_16x16.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        */

        
        //ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER);
    
        JPanel j = new JPanel();
        j.setSize(500, 500);
        j.setBackground(new Color(0, 0, 255));
        

        
        gui = new JFrame();
        gui.setSize(800, 800);
        gui.add(j);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tileMap = new Map(16, 17, gui.getSize());
        gui.add(tileMap);
        gui.setTitle("Test");
        gui.setVisible(true);
        gui.getGraphics().drawLine(0, 0, 100, 100);

        gui.repaint();

    }


}