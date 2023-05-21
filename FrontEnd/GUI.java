import javax.imageio.ImageIO;
import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GUI
{   private Control ctrl;
    private JFrame gWindow;
    private URL sprite;
    private ImageIcon img;
    private JLabel player;

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
    }

    public void gameWindow() throws IOException
    {   sprite = GUI.class.getResource("/Sprites/Male_idle.gif");
        p = new JPanel();

        ////////////////////////////////
        //playerRect = new Rectangle2D.Double();
        //playerRect.setFrame(150, 650, 50, 50);
        playerTex = new TexturePaint(Sprite.toBuff("./Clothes 1/Character1M_1_idle_0.png"), playerRect);


        //gWindow.add(playerRect);
        //gWindow.add(playerTex);
        ///////////////////////////////




        //gWindow = new JFrame();
        gWindow.setSize(1800, 1000);
        gWindow.setTitle("GSWT-Platformer");
        gWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gWindow.setResizable(false);
        //gWindow.setLocation(null);
        gWindow.add(p);

        //img = new ImageIcon(sprite);
        //player = new JLabel(img);
        //player.setLocation(50, 150);
        //p.add(player);

        gWindow.setVisible(true);

    }


    public void paintComponent(Graphics g)
    {   Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(playerTex);
        g2.draw(playerRect);
        //g2.fillRect(100, 100, 50, 50);

    }



    public JFrame getGWindow()
    {
        return gWindow;
    }

    public void reload()
    {   paintComponent(gWindow.getGraphics());
        gWindow.getContentPane().repaint();
        gWindow.repaint();
        
        
    }



    ///////////////////////////////////
    ///////////////////////////////////

    public void setPlayerSprite(BufferedImage s)
    {   

    }


}