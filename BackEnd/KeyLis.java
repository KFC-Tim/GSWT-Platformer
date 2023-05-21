import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyLis implements KeyListener
{   private Control ctrl;
    
    public KeyLis(Control ctrl)
    {   this.ctrl = ctrl;

    }   

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e)
    {   if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {   ctrl.walkRight();
            //System.out.println("Walk Right");
        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            try {
                ctrl.jump();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        ctrl.standStill();
    }

}