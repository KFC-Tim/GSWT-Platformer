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

    private int x, y, w, h;

    private Rectangle2D.Float r;
    private TexturePaint texture;
    
    public Player(int x, int y, int w, int h, BufferedImage start)
    {   super();

        b = start;
        System.out.println(b.getWidth() + " | " + b.getHeight());
        this.setPlayerSprite(start);

        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        r = new Rectangle2D.Float();
        r.setFrame(x, y, w, h);

        texture = new TexturePaint(start, r);

    }

    public void paintComponent(Graphics g)
    {   super.paintComponent(g);
    
        Graphics2D g2 = (Graphics2D) g;
        texture = new TexturePaint(b, r);

        g2.setPaint(texture);
        //g2.drawImage(b, null, x, y);
        Image i = (Image) b;
        //g2.drawImage(i, x, y, w, h, getFocusCycleRootAncestor());

        g2.fill(r);
        g2.setColor(new Color(255, 0, 0));
        g2.draw(r);
        
    }

    public void setPlayerSprite(BufferedImage b)
    {   int bW = b.getWidth();
        int bH = b.getHeight();
        BufferedImage buffImg = new BufferedImage(bW, bH, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(1.5, 1.5);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
        buffImg = scaleOp.filter(b, buffImg);
        this.b = buffImg;
    }


}