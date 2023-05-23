import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Tile extends JPanel
{   private BufferedImage buffImg;
    private Rectangle2D r2;
    private TexturePaint texture;
    private int x,y;

    public Tile(int x, int y, BufferedImage buffImg)
    {   super();
        this.buffImg = buffImg;
        this.x = x;
        this.y = y;

        setBounds(x*16, y*16, 16, 16);

        r2 = new Rectangle2D.Float();
        r2.setFrame(x*16, y*16, 16, 16);
        
        texture = new TexturePaint(buffImg, r2);
    }

    public void paintComponent(Graphics g)
    {   super.paintComponent(g);

        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER);

        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(ac);
        g2.setPaint(texture);
        g2.fill(r2);

        g2.setColor(new Color(255, 0, 0));
        g2.draw(r2);

        g2.dispose();
    }

    public BufferedImage getTexture()
    {   return buffImg;

    }
}
