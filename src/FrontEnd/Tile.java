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

    private HitBox tileHitBox;

    public Tile(int x, int y, BufferedImage buffImg, boolean hitbox)
    {   this.buffImg = buffImg;
        this.x = x;
        this.y = y;

        r2 = new Rectangle2D.Float();
        r2.setFrame(x, y, 16, 16);
        
        texture = new TexturePaint(buffImg, r2);

        if(hitbox)
        {   tileHitBox = new HitBox(x*32, y*32, 32, 32);
            HitBox.add(tileHitBox);
        }
        else
        {   tileHitBox = new HitBox(0,0,0,0);
        }
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
