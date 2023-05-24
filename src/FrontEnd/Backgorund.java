import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JComponent;

public class Backgorund extends JComponent {
    private Image img;

    public Backgorund(Image img)
    {   this.img = img;
    }

    public static Image readImage(String fileName) throws IOException
    {   BufferedImage b = Sprite.toBuff(fileName);
        

        return (Image) b;
    }

    @Override
    public void paintComponent(Graphics g)
    {   super.paintComponent(g);
        g.setClip(0, 0, 1800, 1000);
        g.drawImage(img, 0, 0, 1800, 1000, getFocusCycleRootAncestor());
        g.drawRect(0, 0, 1800, 1000);
    }
}
