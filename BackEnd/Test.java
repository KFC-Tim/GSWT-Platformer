import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

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
        
        r = new Rect(10, 10, 50, 56);
        try {
            p = new Player(100, 100, 100, 100, Sprite.toBuff("./Clothes 1/Character1M_1_idle_0.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        gui.add(r);
        gui.add(p);
        gui.setTitle("Test");

        gui.setVisible(true);

        

    }


}