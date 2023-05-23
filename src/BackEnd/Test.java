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

    private static AlphaComposite ac;

    public static void main(String[] args)
    {   gui = new JFrame();
        gui.setSize(400, 400);

        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
            t = new Tile(10, 10, Sprite.toBuff("./Starter Tiles Platformer/DarkCastleTiles/DarkCastle_1_16x16.png"));
            t2 = new Tile(20, 20, Sprite.toBuff("./Starter Tiles Platformer/DarkCastleTiles/DarkCastle_1_16x16.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER);
    

        

        gui.add(t);
        gui.add(t2);
        gui.setTitle("Test");

        gui.setVisible(true);

        

    }


}