import javax.swing.*;
import javax.xml.XMLConstants;

import java.applet.*;
import java.awt.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Player extends JPanel
{   private BufferedImage b;
    private HitBox playerHitbox;

    private int x, y, w, h;

    private Rectangle2D.Float r;
    private TexturePaint texture;
    
    public Player(int x, int y, int w, int h, BufferedImage start)
    {   super();

        b = start;
        this.setPlayerSprite(start);

        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        

        r = new Rectangle2D.Float();
        r.setFrame(x, y, w, h);
        
        playerHitbox = new HitBox((int) (x+w/2.8), (int) (y+h/3.5), (int) (w/3.5), (int) (h/2.1));

        texture = new TexturePaint(start, r);

    }

    public void paintComponent(Graphics g)
    {   super.paintComponent(g);
    
        Graphics2D g2 = (Graphics2D) g;
        g2.setClip(x, y, w, h);


        texture = new TexturePaint(b, r);
        Rectangle2D.Double r2 = new Rectangle2D.Double();
        r2.setFrame(playerHitbox.getX(), playerHitbox.getY(), playerHitbox.getWidth(), playerHitbox.getHeight());
        r.setFrame(x, y, w, h);
        


        g2.setPaint(texture);

        g2.fill(r);
        g2.setColor(new Color(255, 0, 0));
        g2.draw(r2);
        
    }

    public void setPlayerSprite(BufferedImage b)
    {   this.b = b;
    }

    public void setX(int x)
    {   this.x = x;
        
        playerHitbox.setX((int) (x+w/2.8));
    }

    public void setY(int y)
    {   this.y = y;
        
        playerHitbox.setY((int) (y + h/3.5));
    }

    public int getY0()
    {   return y;

    }

}