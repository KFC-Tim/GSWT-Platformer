import java.awt.Component;

public class HitBox {
    private int x, y, w, h;
    private Component comp;

    public HitBox(int x, int y, int w, int h)
    {   this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

    }

    public HitBox(Component c, int w, int h)
    {   comp = c;
        this.w = w;
        this.h = h;
    }

    private int getMiddleX()
    {   return (int) (comp.getX() + (comp.getWidth()/2));
    }

    private int getMiddleY()
    {   return (int) (comp.getY() + (comp.getHeight()/2));
    }


    public int getX()
    {   return x;
    }

    public int getY()
    {   return y;
    }

    public int getWidth()
    {   return w;
    }

    public int getHeight()
    {   return h;

    }

    public Boolean checkForCollision(HitBox hi)
    {   if(x+w<hi.getX() || hi.getX() + hi.getWidth()<x || y+h<hi.getY() || hi.getHeight() + hi.getY()<y)
        {   return false;
        }
        else
        {   return true;
        }

    }
}
