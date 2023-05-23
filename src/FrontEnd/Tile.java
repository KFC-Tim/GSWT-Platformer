import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Tile
{   private BufferedImage buffImg;
    private Rectangle2D r2;
    private TexturePaint texture;
    private int x,y;

    public Tile(int x, int y, BufferedImage buffImg)
    {   this.buffImg = buffImg;
        this.x = x;
        this.y = y;

        r2 = new Rectangle2D.Float();
        r2.setFrame(x, y, 16, 16);
        
        texture = new TexturePaint(buffImg, r2);
    }


    public BufferedImage getTexture()
    {   return buffImg;
    }

    public int getX()
    {   return x;
    }

    public int getY()
    {   return y;
    }
}
