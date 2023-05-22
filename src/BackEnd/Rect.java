import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Rect extends JPanel {
    private int x, y, w, h;
    private Rectangle2D.Float r2;
    private BufferedImage img;
    private TexturePaint texture;

    public Rect(int x, int y, int w, int h, BufferedImage b)
    {   super();
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        img = b;

        r2 = new Rectangle2D.Float();
        r2.setFrame(x, y, w, h);

        texture = new TexturePaint(img, r2);

        System.out.println("Rect created");
    }
    
    
    public void paintComponent(Graphics g)
    {   super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(new Color(255, 0, 0));
        g2.draw(r2);

        g2.setPaint(texture);
        g2.fill(r2);

        System.out.println("Drawing....");
        
    }
}
