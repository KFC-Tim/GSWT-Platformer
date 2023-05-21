import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import javax.swing.JPanel;

public class Rect extends JPanel {
    private int x, y, w, h;

    public Rect(int x, int y, int w, int h)
    {   this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        
        
        setBounds(x, y, w, h);
    }
    
    
    public void paintComponent(Graphics g)
    {   super.paintComponent(g);


        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(255, 0, 0));
        g2.drawRect(x, y, w, h);
        
    }
}
