import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GUI
{   private Control ctrl;
    private JFrame gWindow;
    private URL sprite;
    private ImageIcon img;
    private JLabel player;

    private JPanel p;

    public GUI(Control c)
    {   ctrl = c;
        gWindow = new JFrame();
    }

    public void gameWindow()
    {   sprite = GUI.class.getResource("/Sprites/Male_idle.gif");
        p = new JPanel();


        //gWindow = new JFrame();
        gWindow.setSize(1800, 1000);
        gWindow.setTitle("GSWT-Platformer");
        gWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gWindow.setResizable(false);
        //gWindow.setLocation(null);
        gWindow.add(p);

        img = new ImageIcon(sprite);
        player = new JLabel(img);
        player.setLocation(50, 150);
        p.add(player);

        gWindow.setVisible(true);
        setFrame("/Sprites/Male_talk.gif");

    }


    public void setFrame(String s)
    {   sprite = GUI.class.getResource(s);
        img = new ImageIcon(sprite);
        player.setIcon(img);
        //player.setLocation(150, 650);
        gWindow.getContentPane().add(p);
    }

    public void setPlayerLocation(int x, int y)
    {   player.setLocation(x, y);
        gWindow.getContentPane().repaint();
    }

    public void changePlayerLocation(int x, int y)
    {   player.setLocation(player.getX()+x, player.getY()+y);

    }

    public JFrame getGWindow()
    {
        return gWindow;
    }


}