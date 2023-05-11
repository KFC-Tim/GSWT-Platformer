import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener
{   private Texture[] textures;
    private int x, y, height, width;
    private Control ctrl;

    public Player(Control c, JFrame j)
    {   this.ctrl = c;
        j.addKeyListener(this);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e)
    {   if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {   ctrl.walkRight();
            System.out.println("Walk Right");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        ctrl.standStill();
    }
}