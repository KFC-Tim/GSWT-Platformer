import java.awt.Component;
import java.awt.geom.Rectangle2D.Float;
import java.util.ArrayList;

import javax.swing.JPanel;

public class HitBox {
    private static HitBox[][] gameHitBoxes = new HitBox[1000][32];
    private int x, y, w, h;
    private Component comp;

    public HitBox(int x, int y, int w, int h)
    {   this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

    }

    public HitBox(Component r, int w, int h)
    {   comp = r;
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


    public void setX(int x)
    {   this.x = x;
    }

    public void setY(int y)
    {   this.y = y;

    }

    public HitBox isHitBox(int x, int y)
    {   return gameHitBoxes[x][y];
    }

    public Boolean checkForCollision(HitBox hi)
    {   if(x+w<hi.getX() || hi.getX() + hi.getWidth()<x || y+h<hi.getY() || hi.getHeight() + hi.getY()<y)
        {   return false;
        }
        else
        {   return true;
        }
    }

    public static void add(HitBox h)
    {   gameHitBoxes[h.getX()/32][h.getY()/32] = h;
    }

    public static HitBox[] getHitboxes1D()
    {   HitBox[] h = new HitBox[gameHitBoxes.length * gameHitBoxes[0].length];

        for(int i=0; i<gameHitBoxes.length; ++i)
        {   for(int j=0; j<gameHitBoxes[0].length; ++j)
            {   h[(i+1)*j] = gameHitBoxes[i][j];
            }
        }

        return h;

    }

    public static int fallsTo(Player player)
    {   HitBox playerHitBox = player.geHitBox();
        
        int xPlayer = playerHitBox.getX();
        
        int yPlayer = playerHitBox.getY();

        if(xPlayer%32 == 0)
        {   for(int i=gameHitBoxes[0].length-1; i>=0; i--)
            {   if(gameHitBoxes[(xPlayer/32)][i] != null)
                {   if(i*32 == 0)
                    {   return 900;

                    }
                    return i*32 -67;
                }
            }
        }
        else
        {   int floor = 0;

            for(int i=gameHitBoxes[0].length-1; i>=0; i--)
            {   if(gameHitBoxes[xPlayer/32][i] != null)
                {   floor = i*32;
                    break;
                }
            }

            for(int i=gameHitBoxes[0].length-1; i>=0; i--)
            {   if(gameHitBoxes[(xPlayer/32) + 1][i] != null)
                {   if(i*32 > floor)
                    {   floor = i*32;
                    }

                    else if(i*32<floor)
                    {   break;
                    }
                    break;
                }
            }
            if(floor == 0)
            {   return 900;

            }
            return floor - 67;
        }

        return 900;
    }

    public JPanel showHitBox()
    {   JPanel j = new JPanel();
        
        j.setBounds(x, y, w, h);

        return j;
    }
}
