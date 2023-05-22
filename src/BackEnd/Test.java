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

    public static void main(String[] args)
    {   gui = new JFrame();
        gui.setSize(400, 400);

        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
            r = new Rect(0, 0, 1000, 1000, Sprite.toBuff("./City/Assets_City.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        gui.add(r);
        gui.setTitle("Test");

        gui.setVisible(true);

        

    }


}