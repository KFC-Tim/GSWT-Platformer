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
        gWindow.setSize(1200, 600);
        gWindow.setTitle("GSWT-Platformer");
        gWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gWindow.setResizable(false);
        //gWindow.setLocation(null);
        gWindow.add(p);

        img = new ImageIcon(sprite);
        player = new JLabel(img);
        p.add(player);

        gWindow.setVisible(true);
        setFrame("/Sprites/Male_talk.gif");

    }


    public void setFrame(String s)
    {   sprite = GUI.class.getResource(s);
        img = new ImageIcon(sprite);
        player.setIcon(img);
        gWindow.getContentPane().add(p);
    }

    public JFrame getGWindow()
    {
        return gWindow;
    }


}